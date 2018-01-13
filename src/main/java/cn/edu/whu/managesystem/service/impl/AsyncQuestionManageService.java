package cn.edu.whu.managesystem.service.impl;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.dao.QuestionMapper;
import cn.edu.whu.managesystem.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public Future<List<Question>> getQuestionsByCondFuture(SelectByCondCommand command) {
        Future<List<Question>> future = new AsyncResult<>(questionMapper.getQuestionByCond(command));
        return future;
    }

    @Async
    public Future<Integer> asyncDeleteQuestion(DeleteCommand command) {
        Future<Integer> future = new AsyncResult<>(questionMapper.deleteQuestionById(command.getId()));
        return future;
    }

    @Async
    public Future<Integer> asyncUpdateQuestion(UpdateCommand command) {
        Future<Integer> future = new AsyncResult<>(questionMapper.updateQuestion(command));
        return future;
    }

    @Async
    public Future<Integer> asyncAddQuestion(InsertCommand command) {
        Future<Integer> future = new AsyncResult<>(questionMapper.addQuestion(command));
        return future;
    }
}
