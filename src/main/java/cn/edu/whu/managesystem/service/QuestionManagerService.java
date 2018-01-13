package cn.edu.whu.managesystem.service;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.vo.QuestionVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Service
public interface QuestionManagerService {

    public List<QuestionVo> getQuestionsByCond(SelectByCondCommand command);

    public Integer deleteQuestion(DeleteCommand command);

    public Integer updateQuestion(UpdateCommand command);

    public Integer addQuestion(InsertCommand command);


}
