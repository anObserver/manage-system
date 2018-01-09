package cn.edu.whu.managesystem;

import cn.edu.whu.managesystem.command.DeleteCommand;
import cn.edu.whu.managesystem.command.InsertCommand;
import cn.edu.whu.managesystem.command.SelectByCondCommand;
import cn.edu.whu.managesystem.command.UpdateCommand;
import cn.edu.whu.managesystem.service.QuestionManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionManagerServiceTest {

    @Autowired
    private QuestionManagerService questionManagerService;

    @Test
    public void getQuestionByCondTest(SelectByCondCommand command) {

    }

    @Test
    public void deleteQuestionTest(DeleteCommand command) {

    }

    @Test
    public void updateQuestionTest(UpdateCommand command) {

    }

    @Test
    public void addQuestionTest(InsertCommand command) {

    }
}
