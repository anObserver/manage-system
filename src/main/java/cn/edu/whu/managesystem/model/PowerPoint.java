package cn.edu.whu.managesystem.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Data
public class PowerPoint implements Serializable{
    private Integer id;
    private String name;
    private Integer isValid;
    private Integer createTime;
    private Integer updateTime;
}
