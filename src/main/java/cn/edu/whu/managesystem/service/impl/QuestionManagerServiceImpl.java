package cn.edu.whu.managesystem.service.impl;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.dao.QuestionMapper;
import cn.edu.whu.managesystem.model.Question;
import cn.edu.whu.managesystem.service.QuestionManagerService;
import cn.edu.whu.managesystem.vo.QuestionVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import static cn.edu.whu.managesystem.utils.FutureUtils.getFutureValue;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Service
public class QuestionManagerServiceImpl implements QuestionManagerService{

    @Autowired
    private AsyncQuestionManageService asyncQuestionManageService;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public PageInfo<QuestionVo> getQuestionsByCond(SelectByCondCommand command) {
        PageHelper.startPage(command.getPageNumber(), command.getPageSize());
        List<QuestionVo> questionVos = new ArrayList<>();
        List<Question> questions = questionMapper.getQuestionByCond(command);

        for (Question question : questions) {
            QuestionVo questionVo = new QuestionVo();
            BeanUtils.copyProperties(question, questionVo);
            questionVos.add(questionVo);
        }
        return new PageInfo<>(questionVos);
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
