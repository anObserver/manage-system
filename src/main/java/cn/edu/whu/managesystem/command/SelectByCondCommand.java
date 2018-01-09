package cn.edu.whu.managesystem.command;

import lombok.Data;

import java.util.List;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Data
public class SelectByCondCommand extends BaseCommand{
    private List<Integer> courseIds;
    private List<Integer> unitIds;
    private List<Integer> typeIds;
    private List<Integer> knowledgePointIds;
    private List<Integer> powerPointIds;
    private List<Integer> difficulty;
}
