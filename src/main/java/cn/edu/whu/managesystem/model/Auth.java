package cn.edu.whu.managesystem.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class Auth implements Serializable {
    private Integer authId;

    private String authName;

    private Integer isValid;

    private String createTime;

    private String updateTime;
}