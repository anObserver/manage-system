package cn.edu.whu.managesystem.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Data
public class CourseAndUnitVo implements Serializable{
    private Integer id;
    private String name;
    private List<CourseAndUnitVo> unit;

    public CourseAndUnitVo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseAndUnitVo() {
    }
}
