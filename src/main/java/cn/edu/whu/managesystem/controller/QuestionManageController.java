package cn.edu.whu.managesystem.controller;

import cn.edu.whu.managesystem.command.*;
import cn.edu.whu.managesystem.result.Result;
import cn.edu.whu.managesystem.result.ResultGenerator;
import cn.edu.whu.managesystem.service.QuestionManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */

@RestController
@RequestMapping(value = "/questionManage")
@Api(value = "/questionManage")
public class QuestionManageController {

    @Autowired
    private QuestionManagerService questionManagerService;

    @PostMapping("/questions")
    @ApiOperation(value = "根据条件查询试题", response = Result.class)
    public Result getQuestionsByCond(@RequestBody SelectByCondCommand command) {
        if (command.getCourseIds().isEmpty()) {
            command.setCourseIds(null);
        }
        if (command.getDifficulty().isEmpty()) {
            command.setDifficulty(null);
        }
        if (command.getTypeIds().isEmpty()) {
            command.setTypeIds(null);
        }
        if (command.getKnowledgePointIds().isEmpty()) {
            command.setKnowledgePointIds(null);
        }
        if (command.getUnitIds().isEmpty()) {
            command.setUnitIds(null);
        }
        if (command.getPowerPointIds().isEmpty()) {
            command.setPowerPointIds(null);
        }
        return ResultGenerator.generateSuccessResult(questionManagerService.getQuestionsByCond(command));
    }

    @PostMapping("/delete")
    @ApiOperation(value="根据ID删除试题", response = Result.class)
    public Result deleteQuestion(@RequestBody DeleteCommand command) {
        return ResultGenerator.generateSuccessResult(questionManagerService.deleteQuestion(command));
    }

    @PostMapping("/update")
    @ApiOperation(value="更新试题", response = Result.class)
    public Result updateQuestion(@RequestBody UpdateCommand command) {
        if (!check(command)) {
            return ResultGenerator.generateFailResult("参数错误");
        }
        return ResultGenerator.generateSuccessResult(questionManagerService.updateQuestion(command));
    }

    @PostMapping("/add")
    @ApiOperation(value="增加试题", response = Result.class)
    public Result addQuestion(@RequestBody InsertCommand command) {
        return ResultGenerator.generateSuccessResult(questionManagerService.addQuestion(command));
    }

    private Boolean check(BaseCommand command) {
        if (command.getId() == null || command.getId() < 0) {
            return false;
        }
        return true;
    }

}
