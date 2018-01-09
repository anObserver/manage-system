package cn.edu.whu.managesystem.command;

import lombok.Data;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/8
 */
@Data
public class AddKnowledgePointCommand extends BaseCommand{
    private Integer courseId;
    private Integer unitId;
    private String knowledgePoint;
}
