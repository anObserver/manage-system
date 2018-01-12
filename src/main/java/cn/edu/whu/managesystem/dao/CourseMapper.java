package cn.edu.whu.managesystem.dao;

import cn.edu.whu.managesystem.command.AddCourseAndUnitCommand;
import cn.edu.whu.managesystem.model.CourseAndUnit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Mapper
public interface CourseMapper {

    List<CourseAndUnit> getAll();

    Integer add(AddCourseAndUnitCommand command);
}
