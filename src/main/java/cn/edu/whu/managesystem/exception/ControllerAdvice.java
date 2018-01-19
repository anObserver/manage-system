package cn.edu.whu.managesystem.exception;

import io.swagger.models.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/19
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    @ModelAttribute
    public void addAttributes(Model model) {}

  /**
   * 统一异常处理
   *
   * @param exception
   *            exception
   * @return
   */
  @ExceptionHandler({ RuntimeException.class })
  @ResponseStatus(HttpStatus.OK)
  public ModelAndView processException(RuntimeException exception) {
    logger.info("自定义异常处理-RuntimeException");
    ModelAndView m = new ModelAndView();
    m.addObject("roncooException", exception.getMessage());
    m.setViewName("error/500");
    return m;
  }

  /**
   * 统一异常处理
   *
   * @param exception
   *            exception
   * @return
   */
  @ExceptionHandler({ Exception.class })
  @ResponseStatus(HttpStatus.OK)
  public ModelAndView processException(Exception exception) {
    logger.info("自定义异常处理-Exception");
    ModelAndView m = new ModelAndView();
    m.addObject("roncooException", exception.getMessage());
    m.setViewName("error/500");
    return m;
  }
}
