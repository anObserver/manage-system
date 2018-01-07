package cn.edu.whu.managesystem.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Data
public class CourseAndUnitVo implements Serializable{
    private Integer courseId;
    private Integer unitId;
    private String courseName;
    private String unitName;
}
