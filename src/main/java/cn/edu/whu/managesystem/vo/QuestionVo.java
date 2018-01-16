package cn.edu.whu.managesystem.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/7
 */
@Data
public class QuestionVo implements Serializable{
    private Integer questionId;

    private Integer courseId;

    private Integer typeId;

    private Integer unitId;

    private Integer difficulty;

    private Integer knowledgePointId;

    private Integer powerPointId;

    private String context;

    private String answer;
}
