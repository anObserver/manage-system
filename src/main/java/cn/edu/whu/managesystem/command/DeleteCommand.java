package cn.edu.whu.managesystem.command;

import lombok.Data;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class DeleteCommand extends BaseCommand{
    private List<Integer> deleteIds;
}
