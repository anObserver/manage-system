package cn.edu.whu.managesystem.service.impl;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/13
 */
@Component
public class AsyncQuestionManageService {
    @Autowired
    private QuestionMapper questionMapper;

    @Async
    public Future<Integer> asyncDeleteQuestion(DeleteCommand command) {
        return new AsyncResult<>(questionMapper.deleteQuestionByIds(command.getDeleteIds()));
    }

    @Async
    public Future<Integer> asyncUpdateQuestion(UpdateCommand command) {
        return new AsyncResult<>(questionMapper.updateQuestion(command));
    }

    @Async
    public Future<Integer> asyncAddQuestion(InsertCommand command) {
        return new AsyncResult<>(questionMapper.addQuestion(command));
    }
}
