package cn.edu.whu.managesystem.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class Role implements Serializable {
    private Integer roleId;

    private String roleName;

    private Integer isValid;

    private Integer createTime;

    private Integer updateTime;
}
