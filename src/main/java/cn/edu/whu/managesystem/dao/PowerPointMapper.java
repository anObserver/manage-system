package cn.edu.whu.managesystem.dao;

import cn.edu.whu.managesystem.command.AddPowerPointCommand;
import cn.edu.whu.managesystem.model.PowerPoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Mapper
public interface PowerPointMapper {

    List<PowerPoint> getAll();

    Integer add(AddPowerPointCommand command);
}
