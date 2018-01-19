package cn.edu.whu.managesystem.utils.aop;

import cn.edu.whu.managesystem.exception.ControllerAdvice;
import cn.edu.whu.managesystem.utils.result.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/19
 */
@Aspect
@Component
public class HttpAspect {

  private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

  @Autowired
  private ControllerAdvice controllerAdvice;

  @Pointcut("execution(public * cn.edu.whu.managesystem.controller.*.*(..))")
  public void log(){

  }

  @Before("log()")
  public void doBefore(JoinPoint joinPoint){
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    //url
    LOGGER.info("url={}",request.getRequestURL());
    //method
    LOGGER.info("method={}",request.getMethod());
    //ip
    LOGGER.info("id={}",request.getRemoteAddr());
    //class_method
    LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
    //args[]
    LOGGER.info("args={}",joinPoint.getArgs());
  }

  @Around("log()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Result result = null;
    try {

    } catch (Exception e) {
      return controllerAdvice.processException(e);
    }
    if(result == null){
      return proceedingJoinPoint.proceed();
    }else {
      return result;
    }
  }

  @AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
  public void doAfterReturing(Object object){
    LOGGER.info("response={}",object.toString());
  }
}
