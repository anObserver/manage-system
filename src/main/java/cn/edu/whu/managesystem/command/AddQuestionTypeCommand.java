package cn.edu.whu.managesystem.command;

import lombok.Data;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/8
 */
@Data
public class AddQuestionTypeCommand extends BaseCommand{
    private String questionType;
}
