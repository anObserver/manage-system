package cn.edu.whu.managesystem.command;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public abstract class BaseCommand implements Serializable{
    protected Integer id;
}
