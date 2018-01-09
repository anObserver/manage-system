package cn.edu.whu.managesystem;

import cn.edu.whu.managesystem.command.AddCourseAndUnitCommand;
import cn.edu.whu.managesystem.command.AddKnowledgePointCommand;
import cn.edu.whu.managesystem.command.AddPowerPointCommand;
import cn.edu.whu.managesystem.command.AddQuestionTypeCommand;
import cn.edu.whu.managesystem.service.DimListService;
import cn.edu.whu.managesystem.vo.CourseAndUnitVo;
import cn.edu.whu.managesystem.vo.PowerPointVo;
import cn.edu.whu.managesystem.vo.QuestionTypeVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DimListServiceTest {

    @Autowired
    private DimListService dimListService;


    @Test
    public void getCourseAndUnitsTest() {
        List<CourseAndUnitVo> courseAndUnits = dimListService.getCourseAndUnits();
        System.out.println(courseAndUnits);
    }

    @Test
    public void getPowerPointTest() {
        List<PowerPointVo> powerPointVos = dimListService.getPowerPoints();
        System.out.println(powerPointVos);
    }

    @Test
    public void getQuestionTypeTest() {
        List<QuestionTypeVo> questionTypeVos = dimListService.getQuestionTypes();
        System.out.println(questionTypeVos);
    }

    @Test
    public void addCourseAndUnitTest() {
        AddCourseAndUnitCommand command = new AddCourseAndUnitCommand();
        command.setCourseName("高等数学");
        command.setUnitName("第一章");
        command.setUnitId(1);
        dimListService.addCourseAndUnit(command);
    }

    @Test
    public void addPowerPointTest() {
        AddPowerPointCommand command = new AddPowerPointCommand();
        command.setPowerPoint("能力点1");
        dimListService.addPowerPoint(command);
    }

    @Test
    public void addQuestionTypeTest() {
        AddQuestionTypeCommand command = new AddQuestionTypeCommand();
        command.setQuestionType("选择题");
        dimListService.addQuestionType(command);
    }

    @Test
    public void addKnowledgePointTest() {
        AddKnowledgePointCommand command = new AddKnowledgePointCommand();
        command.setCourseId(1);
        command.setKnowledgePoint("知识点1");
        command.setUnitId(1);
        dimListService.addKnowledgePoint(command);
    }
}
