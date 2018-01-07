package cn.edu.whu.managesystem.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class TestPaper implements Serializable{
    private Integer testPaperId;

    private String testPaperName;

    private String questionIds;

    private Integer isValid;

    private Integer createTime;

    private Integer updateTime;
}
