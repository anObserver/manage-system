package cn.edu.whu.managesystem.utils.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;
}
