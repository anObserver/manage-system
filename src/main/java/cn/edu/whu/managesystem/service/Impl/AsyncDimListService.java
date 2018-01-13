package cn.edu.whu.managesystem.service.Impl;

import cn.edu.whu.managesystem.command.*;
import cn.edu.whu.managesystem.dao.CourseMapper;
import cn.edu.whu.managesystem.dao.KnowledgePointMapper;
import cn.edu.whu.managesystem.dao.PowerPointMapper;
import cn.edu.whu.managesystem.dao.QuestionTypeMapper;
import cn.edu.whu.managesystem.model.CourseAndUnit;
import cn.edu.whu.managesystem.model.KnowledgePoint;
import cn.edu.whu.managesystem.model.PowerPoint;
import cn.edu.whu.managesystem.model.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/13
 */
@Component
public class AsyncDimListService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private KnowledgePointMapper knowledgePointMapper;

    @Autowired
    private PowerPointMapper powerPointMapper;

    @Autowired
    private QuestionTypeMapper questionTypeMapper;


    @Async
    public Future<List<CourseAndUnit>> getCourseAndUnitsFuture() {
        Future<List<CourseAndUnit>> future = new AsyncResult<>(courseMapper.getAll());
        return future;

    }

    @Async
    public Future<List<KnowledgePoint>> getKnowledgePointsFuture(GetKnowledgePointCommand command) {
        Future<List<KnowledgePoint>> future = new AsyncResult<>(knowledgePointMapper.getAll(command));
        return future;
    }

    @Async
    public Future<List<PowerPoint>> getPowerPointsFuture() {
        Future<List<PowerPoint>> future = new AsyncResult<>(powerPointMapper.getAll());
        return future;
    }

    @Async
    public Future<List<QuestionType>> getQuestionTypesFuture() {
        Future<List<QuestionType>> future = new AsyncResult<>(questionTypeMapper.getAll());
        return future;
    }

    @Async
    public Future<Integer> asyncAddCourseAndUnit(AddCourseAndUnitCommand command) {
        return new AsyncResult<>(courseMapper.add(command));
    }

    @Async
    public Future<Integer> asyncAddQuestionType(AddQuestionTypeCommand command) {
        return new AsyncResult<>(questionTypeMapper.add(command));
    }

    @Async
    public Future<Integer> asyncAddKnowledgePoint(AddKnowledgePointCommand command) {
        return new AsyncResult<>(knowledgePointMapper.add(command));
    }

    @Async
    public Future<Integer> asyncAddPowerPoint(AddPowerPointCommand command) {
        return new AsyncResult<>(powerPointMapper.add(command));
    }
}
