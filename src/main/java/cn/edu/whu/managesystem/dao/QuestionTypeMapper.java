package cn.edu.whu.managesystem.dao;

import cn.edu.whu.managesystem.command.AddQuestionTypeCommand;
import cn.edu.whu.managesystem.model.QuestionType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Mapper
public interface QuestionTypeMapper {

    public List<QuestionType> getAll();

    public Integer add(AddQuestionTypeCommand command);
}
