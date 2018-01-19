package cn.edu.whu.managesystem.controller;

import cn.edu.whu.managesystem.command.*;
import cn.edu.whu.managesystem.service.DimListService;
import cn.edu.whu.managesystem.utils.result.Result;
import cn.edu.whu.managesystem.utils.result.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@RestController
@RequestMapping("/list")
@Api(value = "/list")
public class DimListController {

    Logger logger = LoggerFactory.getLogger(DimListController.class);

    @Autowired
    private DimListService dimListService;

    @PostMapping("/courseAndUnit")
    @ApiOperation(value = "获取课程和单元信息", response = Result.class)
    public Result getCourseAndUnits() {
        return ResultGenerator.generateSuccessResult(dimListService.getCourseAndUnits());
    }

    @PostMapping("/units")
    @ApiOperation(value = "根据课程ID获取单元", response = Result.class)
    public Result getUnitsByCourseId(@RequestBody GetUnitCommand command) {
        return ResultGenerator.generateSuccessResult(dimListService.getUnitsByCourseId(command));
    }

    @PostMapping("/addCourseAndUnit")
    @ApiOperation(value = "新增课程和单元信息", response = Result.class)
    public Result addCourseAndUnit(@RequestBody AddCourseAndUnitCommand command) {
        return ResultGenerator.generateSuccessResult(dimListService.addCourseAndUnit(command));
    }

    @PostMapping("/knowledgePoint")
    @ApiOperation(value = "获取知识点列表", response = Result.class)
    public Result getKnowledgePoints(@RequestBody GetKnowledgePointCommand command) {
        return ResultGenerator.generateSuccessResult(dimListService.getKnowledgePoints(command));
    }

    @PostMapping("/addKnowledgePoint")
    @ApiOperation(value = "增加知识点", response = Result.class)
    public Result addKnowledgePoint(@RequestBody AddKnowledgePointCommand command) {
        return ResultGenerator.generateSuccessResult(dimListService.addKnowledgePoint(command));
    }

    @PostMapping("/powerPoint")
    @ApiOperation(value = "获取能力点列表", response = Result.class)
    public Result getPowerPoints() {
        return ResultGenerator.generateSuccessResult(dimListService.getPowerPoints());
    }

    @PostMapping("/addPowerPoint")
    @ApiOperation(value = "增加能力点", response = Result.class)
    public Result addPowerPoint(@RequestBody AddPowerPointCommand command) {
        return ResultGenerator.generateSuccessResult(dimListService.addPowerPoint(command));
    }

    @PostMapping("/questionType")
    @ApiOperation(value = "获取题型列表", response = Result.class)
    public Result getQuestionTypes() {
        return ResultGenerator.generateSuccessResult(dimListService.getQuestionTypes());
    }

    @PostMapping("/addQuestionType")
    @ApiOperation(value = "增加题型", response = Result.class)
    public Result addQuestionType(@RequestBody AddQuestionTypeCommand command) {
        return ResultGenerator.generateSuccessResult(dimListService.addQuestionType(command));
    }
}
