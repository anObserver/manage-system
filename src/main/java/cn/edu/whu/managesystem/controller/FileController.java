package cn.edu.whu.managesystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/19
 */
@Controller
@Api
@RequestMapping(value = "/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "upload")
    @ApiOperation(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("f") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：{}", fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf('.'));
        logger.info("上传的后缀名为：{}", suffixName);

        // 文件上传路径
        String filePath = "/tmp";

        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;

        File dest = new File(filePath + fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            logger.error("IllegalStateException: ", e);
        } catch (IOException e) {
            logger.error("IOException: ", e);
        }
        return "上传失败";
    }

}
