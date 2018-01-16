package cn.edu.whu.managesystem.service;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.vo.QuestionVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Service
public interface QuestionManagerService {

    /**
     * 根据条件获取试题
     * @param command 前端传的条件
     * @return 查询的试题
     */
    PageInfo<QuestionVo> getQuestionsByCond(SelectByCondCommand command);

    /**
     * 删除试题
     * @param command 试题ID
     * @return delete的返回值
     */
    Integer deleteQuestion(DeleteCommand command);

    /**
     * 更新试题
     * @param command 前端传的条件
     * @return update的返回值
     */
    Integer updateQuestion(UpdateCommand command);

    /**
     * 添加试题
     * @param command 前端传的信息
     * @return insert的返回值
     */
    Integer addQuestion(InsertCommand command);


}
