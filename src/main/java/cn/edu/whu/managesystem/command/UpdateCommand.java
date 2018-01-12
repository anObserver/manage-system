package cn.edu.whu.managesystem.command;

import lombok.Data;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class UpdateCommand extends BaseCommand{
    private String context;
    private String answer;
    private Integer courseId;
    private Integer unitId;
    private Integer typeId;
    private Integer difficulty;
    private Integer knowledgePointId;
    private Integer powerPointId;
}
