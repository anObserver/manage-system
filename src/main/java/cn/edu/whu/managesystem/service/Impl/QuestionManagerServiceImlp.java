package cn.edu.whu.managesystem.service.Impl;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.dao.QuestionMapper;
import cn.edu.whu.managesystem.model.Question;
import cn.edu.whu.managesystem.service.QuestionManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Service
public class QuestionManagerServiceImlp implements QuestionManagerService{

    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public List<Question> getQuestionsByCond(SelectByCondCommand command) {
        return questionMapper.getQuestionByCond(command);
    }

    @Override
    public Integer deleteQuestion(DeleteCommand command) {
        return questionMapper.deleteQuestionById(command.getId());
    }

    @Override
    public Integer updateQuestion(UpdateCommand command) {
        return questionMapper.updateQuestion(command);
    }

    @Override
    public Integer addQuestion(InsertCommand command) {
        return questionMapper.addQuestion(command);
    }
}
