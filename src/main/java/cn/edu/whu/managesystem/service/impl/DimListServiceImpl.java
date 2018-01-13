package cn.edu.whu.managesystem.service.impl;

import cn.edu.whu.managesystem.command.*;
import cn.edu.whu.managesystem.model.CourseAndUnit;
import cn.edu.whu.managesystem.model.KnowledgePoint;
import cn.edu.whu.managesystem.model.PowerPoint;
import cn.edu.whu.managesystem.model.QuestionType;
import cn.edu.whu.managesystem.service.DimListService;
import cn.edu.whu.managesystem.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static cn.edu.whu.managesystem.utils.FutureUtils.getFutureValue;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Service
public class DimListServiceImpl implements DimListService{

    private static final Logger logger = LoggerFactory.getLogger(DimListServiceImpl.class);

    @Autowired
    private AsyncDimListService asyncDimListService;


    @Override
    public List<CourseAndUnitVo> getCourseAndUnits() {
        Future<List<CourseAndUnit>> future = asyncDimListService.getCourseAndUnitsFuture();
        List<CourseAndUnitVo> courseAndUnitVos = new ArrayList<>();
        try {
            List<CourseAndUnit> courseAndUnits = future.get();
            if (courseAndUnits == null) {
                return courseAndUnitVos;
            }
            for (CourseAndUnit courseAndUnit : courseAndUnits) {
                CourseAndUnitVo courseAndUnitVo = new CourseAndUnitVo();
                BeanUtils.copyProperties(courseAndUnit, courseAndUnitVo);
                courseAndUnitVos.add(courseAndUnitVo);
            }
        } catch (InterruptedException e) {
            logger.info("getCourseAndUnits interrupt: ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.info("getCourseAndUnits execute exception: ", e);
        }
        return courseAndUnitVos;
    }

    @Override
    public List<KnowledgePointVo> getKnowledgePoints(GetKnowledgePointCommand command) {
        Future<List<KnowledgePoint>> future = asyncDimListService.getKnowledgePointsFuture(command);
        List<KnowledgePointVo> knowledgePointVos = new ArrayList<>();
        try {
            List<KnowledgePoint> knowledgePoints = future.get();
            if (knowledgePoints == null) {
                return knowledgePointVos;
            }
            for (KnowledgePoint knowledgePoint : knowledgePoints) {
                KnowledgePointVo knowledgePointVo = new KnowledgePointVo();
                BeanUtils.copyProperties(knowledgePoint, knowledgePointVo);
                knowledgePointVos.add(knowledgePointVo);
            }
        } catch (InterruptedException e) {
            logger.info("getKnowledgePoints interrupt: ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.info("getKnowledgePoints execute exception: ", e);
        }
        return knowledgePointVos;
    }

    @Override
    public List<PowerPointVo> getPowerPoints() {
        Future<List<PowerPoint>> future = asyncDimListService.getPowerPointsFuture();
        List<PowerPointVo> powerPointVos = new ArrayList<>();
        try {
            List<PowerPoint> powerPoints = future.get();
            if (powerPoints == null) {
                return powerPointVos;
            }
            for (PowerPoint powerPoint : powerPoints) {
                PowerPointVo powerPointVo = new PowerPointVo();
                BeanUtils.copyProperties(powerPoint, powerPointVo);
                powerPointVos.add(powerPointVo);
            }
        } catch (InterruptedException e) {
            logger.info("getPowerPoints interrupt: ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.info("getPowerPoints execute exception: ", e);
        }
        return powerPointVos;
    }

    @Override
    public List<QuestionTypeVo> getQuestionTypes() {
        Future<List<QuestionType>> future = asyncDimListService.getQuestionTypesFuture();
        List<QuestionTypeVo> questionTypeVos = new ArrayList<>();
        try {
            List<QuestionType> questionTypes = future.get();
            if (questionTypes == null) {
                return questionTypeVos;
            }
            for (QuestionType questionType : questionTypes) {
                QuestionTypeVo questionTypeVo = new QuestionTypeVo();
                BeanUtils.copyProperties(questionType, questionTypeVo);
                questionTypeVos.add(questionTypeVo);
            }
        } catch (InterruptedException e) {
            logger.info("getQuestionTypes interrupt: ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.info("getQuestionTypes execute exception: ", e);
        }
        return questionTypeVos;
    }

    @Override
    public Integer addCourseAndUnit(AddCourseAndUnitCommand command) {
        Future<Integer> future = asyncDimListService.asyncAddCourseAndUnit(command);
        return getFutureValue(Thread.currentThread().getStackTrace()[1].getMethodName(), future);
    }

    @Override
    public Integer addQuestionType(AddQuestionTypeCommand command) {
        Future<Integer> future = asyncDimListService.asyncAddQuestionType(command);
        return getFutureValue(Thread.currentThread().getStackTrace()[1].getMethodName(), future);
    }

    @Override
    public Integer addKnowledgePoint(AddKnowledgePointCommand command) {
        Future<Integer> future = asyncDimListService.asyncAddKnowledgePoint(command);
        return getFutureValue(Thread.currentThread().getStackTrace()[1].getMethodName(), future);
    }

    @Override
    public Integer addPowerPoint(AddPowerPointCommand command) {
        Future<Integer> future = asyncDimListService.asyncAddPowerPoint(command);
        return getFutureValue(Thread.currentThread().getStackTrace()[1].getMethodName(), future);
    }
}
