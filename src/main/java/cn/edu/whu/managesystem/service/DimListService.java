package cn.edu.whu.managesystem.service;

import cn.edu.whu.managesystem.command.*;
import cn.edu.whu.managesystem.result.Result;
import cn.edu.whu.managesystem.result.ResultGenerator;
import cn.edu.whu.managesystem.vo.CourseAndUnitVo;
import cn.edu.whu.managesystem.vo.KnowledgePointVo;
import cn.edu.whu.managesystem.vo.PowerPointVo;
import cn.edu.whu.managesystem.vo.QuestionTypeVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Service
public interface DimListService {
    public List<CourseAndUnitVo> getCourseAndUnits();

    public List<KnowledgePointVo> getKnowledgePoints(GetKnowledgePointCommand command);

    public List<PowerPointVo> getPowerPoints();

    public List<QuestionTypeVo> getQuestionTypes();

    public Integer addCourseAndUnit(AddCourseAndUnitCommand command);

    public Integer addQuestionType(AddQuestionTypeCommand command);

    public Integer addKnowledgePoint(AddKnowledgePointCommand command);

    public Integer addPowerPoint(AddPowerPointCommand command);
}
