package cn.edu.whu.managesystem.command;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Data
public class GetKnowledgePointCommand extends BaseCommand{
    private Integer courserId;
    private Integer unitId;
}
