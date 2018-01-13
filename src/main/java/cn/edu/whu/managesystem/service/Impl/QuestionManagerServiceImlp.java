package cn.edu.whu.managesystem.service.Impl;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.model.Question;
import cn.edu.whu.managesystem.service.QuestionManagerService;
import cn.edu.whu.managesystem.vo.QuestionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static cn.edu.whu.managesystem.utils.FutureUtils.getFutureValue;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Service
public class QuestionManagerServiceImlp implements QuestionManagerService{

    private Logger logger = LoggerFactory.getLogger(QuestionManagerServiceImlp.class);

    @Autowired
    private AsyncQuestionManageService asyncQuestionManageService;

    public List<QuestionVo> getQuestionsByCond(SelectByCondCommand command) {
        List<QuestionVo> questionVos = new ArrayList<>();
        Future<List<Question>> future = asyncQuestionManageService.getQuestionsByCondFuture(command);
        try {
            List<Question> questions = future.get();
            for (Question question : questions) {
                QuestionVo questionVo = new QuestionVo();
                BeanUtils.copyProperties(question, questionVo);
                questionVos.add(questionVo);
            }
        } catch (InterruptedException e) {
            logger.info("GetQuestionbycond interrupt: ", e);
        } catch (ExecutionException e) {
            logger.info("GetQuestionbycond execute excetipn: ", e);
        }
        return questionVos;
    }

    @Override
    public Integer deleteQuestion(DeleteCommand command) {
        Future<Integer> future = asyncQuestionManageService.asyncDeleteQuestion(command);
        return getFutureValue(Thread.currentThread().getStackTrace()[1].getMethodName(), future);
    }

    @Override
    public Integer updateQuestion(UpdateCommand command) {
        Future<Integer> future = asyncQuestionManageService.asyncUpdateQuestion(command);
        return getFutureValue(Thread.currentThread().getStackTrace()[1].getMethodName(), future);
    }

    @Override
    public Integer addQuestion(InsertCommand command) {
        Future<Integer> future = asyncQuestionManageService.asyncAddQuestion(command);
        return getFutureValue(Thread.currentThread().getStackTrace()[1].getMethodName(), future);
    }
}
