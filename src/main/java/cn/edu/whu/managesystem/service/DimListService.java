package cn.edu.whu.managesystem.service;

import cn.edu.whu.managesystem.command.*;
import cn.edu.whu.managesystem.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Service
public interface DimListService {
    List<CourseAndUnitVo> getCourseAndUnits();

    List<KnowledgePointVo> getKnowledgePoints(GetKnowledgePointCommand command);

    List<PowerPointVo> getPowerPoints();

    List<QuestionTypeVo> getQuestionTypes();

    Integer addCourseAndUnit(AddCourseAndUnitCommand command);

    Integer addQuestionType(AddQuestionTypeCommand command);

    Integer addKnowledgePoint(AddKnowledgePointCommand command);

    Integer addPowerPoint(AddPowerPointCommand command);

    List<UnitVo> getUnitsByCourseId(GetUnitCommand command);
}
