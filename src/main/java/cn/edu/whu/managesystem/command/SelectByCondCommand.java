package cn.edu.whu.managesystem.command;

import lombok.Data;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class SelectByCondCommand extends BaseCommand{
    private Integer courseId;
    private Integer unit;
    private Integer typeId;
    private Integer knowledgePoint;
    private Integer powerPoint;
    private Integer difficulty;
}
