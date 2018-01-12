package cn.edu.whu.managesystem.dao;

import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Mapper
public interface QuestionMapper {
    public List<Question> getQuestionByCond(SelectByCondCommand command);

    public Integer deleteQuestionById(Integer questionId);

    public Integer updateQuestion(UpdateCommand command);

    public Integer addQuestion(InsertCommand command);
}