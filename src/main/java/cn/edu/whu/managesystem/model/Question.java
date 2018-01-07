package cn.edu.whu.managesystem.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class Question implements Serializable{
    private Integer questionId;

    private Integer courseId;

    private Integer typeId;

    private Integer unitId;

    private Integer difficutily;

    private Integer knowledgePointId;

    private Integer powerPointId;

    private String context;

    private String answer;

    private Integer isValid;

    private Integer createTime;

    private Integer updateTime;
}