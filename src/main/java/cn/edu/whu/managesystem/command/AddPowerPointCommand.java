package cn.edu.whu.managesystem.command;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/8
 */
@Data
public class AddPowerPointCommand implements Serializable{
    private String powerPoint;
}
