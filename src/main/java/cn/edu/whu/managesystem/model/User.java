package cn.edu.whu.managesystem.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class User implements Serializable{
    private Integer id;

    private String name;

    private Integer sex;

    private Integer isValid;

    private String userId;

    private String password;

    private String roldIds;

    private Integer createTime;

    private Integer updateTime;
}