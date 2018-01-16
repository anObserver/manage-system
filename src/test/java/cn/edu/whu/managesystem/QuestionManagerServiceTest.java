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

import static com.google.common.primitives.Ints.asList;

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
    public void getQuestionByCondTest() {
        SelectByCondCommand command = new SelectByCondCommand();
        command.setPageNumber(1);
        command.setPageSize(2);
        command.setCourseIds(asList(2));
        command.setDifficulty(asList(10));
        command.setUnitIds(asList(2));
        command.setKnowledgePointIds(asList(10));
        command.setPowerPointIds(asList(10));
        command.setTypeIds(asList(10));
        System.out.println(questionManagerService.getQuestionsByCond(command));
    }

    @Test
    public void deleteQuestionTest() {
        DeleteCommand command = new DeleteCommand();
        command.setId(1);
        System.out.println(questionManagerService.deleteQuestion(command));
    }

    @Test
    public void updateQuestionTest() {
        UpdateCommand command = new UpdateCommand();
        command.setAnswer("new answer");
        command.setContext("new context");
        command.setCourseId(2);
        command.setUnitId(2);
        command.setDifficulty(10);
        command.setKnowledgePointId(10);
        command.setPowerPointId(10);
        command.setTypeId(10);
        command.setId(1);
        System.out.println(questionManagerService.updateQuestion(command));
    }

    @Test
    public void addQuestionTest() {
        InsertCommand command = new InsertCommand();
        command.setAnswer("answer");
        command.setContext("question");
        command.setCourseId(1);
        command.setUnitId(1);
        command.setDifficulty(1);
        command.setKnowledgePointId(1);
        command.setPowerPointId(1);
        command.setTypeId(1);
        System.out.println(questionManagerService.addQuestion(command));
    }
}
