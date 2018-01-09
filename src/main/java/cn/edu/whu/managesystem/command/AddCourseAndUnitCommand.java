package cn.edu.whu.managesystem.command;

import lombok.Data;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/8
 */
@Data
public class AddCourseAndUnitCommand extends BaseCommand{
    private String courseName;
    private String unitName;
    private Integer unitId;
}
