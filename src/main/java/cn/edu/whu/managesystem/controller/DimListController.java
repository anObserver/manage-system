package cn.edu.whu.managesystem.controller;

import cn.edu.whu.managesystem.command.GetKnowledgePointCommand;
import cn.edu.whu.managesystem.result.Result;
import cn.edu.whu.managesystem.result.ResultGenerator;
import cn.edu.whu.managesystem.service.DimListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@RestController
@RequestMapping("/list")
@Api(value = "/list", description = "获取维度列表接口")
public class DimListController {

    @Autowired
    private DimListService dimListService;

    @PostMapping("/courseAndUnit")
    @ApiOperation(value = "获取课程和单元信息", response = Result.class)
    public Result getCourseAndUnits() {
        return ResultGenerator.generateSuccessResult(dimListService.getCourseAndUnits());
    }

    @PostMapping("/knowledgePoint")
    @ApiOperation(value = "获取知识点列表", response = Result.class)
    public Result getKnowledgePoints(GetKnowledgePointCommand command) {
        return ResultGenerator.generateSuccessResult(dimListService.getKnowledgePoints(command));
    }

    @PostMapping("/powerPoint")
    @ApiOperation(value = "获取能力点列表", response = Result.class)
    public Result getPowerPoints() {
        return ResultGenerator.generateSuccessResult(dimListService.getPowerPoints());
    }

    @PostMapping("/questionType")
    @ApiOperation(value = "获取题型列表", response = Result.class)
    public Result getQuestionTypes() {
        return ResultGenerator.generateSuccessResult(dimListService.getQuestionTypes());
    }
}
