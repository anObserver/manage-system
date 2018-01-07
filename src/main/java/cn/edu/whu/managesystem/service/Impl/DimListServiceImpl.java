package cn.edu.whu.managesystem.service.Impl;

import cn.edu.whu.managesystem.command.GetKnowledgePointCommand;
import cn.edu.whu.managesystem.dao.*;
import cn.edu.whu.managesystem.model.CourseAndUnit;
import cn.edu.whu.managesystem.model.KnowledgePoint;
import cn.edu.whu.managesystem.model.PowerPoint;
import cn.edu.whu.managesystem.model.QuestionType;
import cn.edu.whu.managesystem.service.DimListService;
import cn.edu.whu.managesystem.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Service
public class DimListServiceImpl implements DimListService{

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private KnowledgePointMapper knowledgePointMapper;

    @Autowired
    private PowerPointMapper powerPointMapper;

    @Autowired
    private QuestionTypeMapper questionTypeMapper;


    @Override
    public List<CourseAndUnitVo> getCourseAndUnits() {
        List<CourseAndUnit> courseAndUnits = courseMapper.getAll();
        List<CourseAndUnitVo> courseAndUnitVos = new ArrayList<>();
        for (CourseAndUnit courseAndUnit : courseAndUnits) {
            CourseAndUnitVo courseAndUnitVo = new CourseAndUnitVo();
            BeanUtils.copyProperties(courseAndUnit, courseAndUnitVo);
            courseAndUnitVos.add(courseAndUnitVo);
        }
        return courseAndUnitVos;
    }

    @Override
    public List<KnowledgePointVo> getKnowledgePoints(GetKnowledgePointCommand command) {
        List<KnowledgePointVo> knowledgePointVos = new ArrayList<>();
        List<KnowledgePoint> knowledgePoints = knowledgePointMapper.getAll(command);
        for (KnowledgePoint knowledgePoint : knowledgePoints) {
            KnowledgePointVo knowledgePointVo = new KnowledgePointVo();
            BeanUtils.copyProperties(knowledgePoint, knowledgePointVo);
            knowledgePointVos.add(knowledgePointVo);
        }
        return knowledgePointVos;
    }

    @Override
    public List<PowerPointVo> getPowerPoints() {
        List<PowerPointVo> powerPointVos = new ArrayList<>();
        List<PowerPoint> powerPoints = powerPointMapper.getAll();
        for (PowerPoint powerPoint : powerPoints) {
            PowerPointVo powerPointVo = new PowerPointVo();
            BeanUtils.copyProperties(powerPoint, powerPointVo);
            powerPointVos.add(powerPointVo);
        }
        return powerPointVos;
    }

    @Override
    public List<QuestionTypeVo> getQuestionTypes() {
        List<QuestionTypeVo> questionTypeVos = new ArrayList<>();
        List<QuestionType> questionTypes = questionTypeMapper.getAll();
        for (QuestionType questionType : questionTypes) {
            QuestionTypeVo questionTypeVo = new QuestionTypeVo();
            BeanUtils.copyProperties(questionType, questionTypeVo);
            questionTypeVos.add(questionTypeVo);
        }
        return questionTypeVos;
    }
}
