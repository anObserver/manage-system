package cn.edu.whu.managesystem.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Data
public class QuestionType implements Serializable{
    private Integer questionTypeId;
    private String questionTypeName;
    private Integer isValid;
    private Integer createTime;
    private Integer updateTime;
}
