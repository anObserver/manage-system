package cn.edu.whu.managesystem.dao;

import cn.edu.whu.managesystem.command.AddKnowledgePointCommand;
import cn.edu.whu.managesystem.command.GetKnowledgePointCommand;
import cn.edu.whu.managesystem.model.KnowledgePoint;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Mapper
public interface KnowledgePointMapper {

    public List<KnowledgePoint> getAll(GetKnowledgePointCommand command);

    public Integer add(AddKnowledgePointCommand command);
}
