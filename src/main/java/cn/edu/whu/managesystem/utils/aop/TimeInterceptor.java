package cn.edu.whu.managesystem.utils.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/13
 */
@Aspect
@Component
public class TimeInterceptor {

    private Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    /**
     * service层面的统计耗时切面，类型必须为final String类型的，注解里要使用的变量只能是静态常量类型的
     */
    private static final String SERVER_POINT = "execution (* cn.edu.whu.managesystem.service.Impl.*.*(..))";

    /**
     * dao 层面的统计耗时
     */
    private static final String DAO_POINT = "execution (* cn.edu.whu.managesystem.dao.*.*(..))";

    /**
     * controller层面统计耗时
     */
    private static final String WEB_POINT = "execution (* cn.edu.whu.managesystem.controller.*.*(..))";

    /**
     * test统计耗时
     */
    private static final String TEST_POINT = "execution (* cn.edu.whu.managesystem.*.*(..))";

    @Around(SERVER_POINT)
    public Object serviceTimeAround(ProceedingJoinPoint joinPoint) {
        return this.timeAround(joinPoint);
    }

    @Around(TEST_POINT)
    public Object testTimeAround(ProceedingJoinPoint joinPoint) {
        return this.timeAround(joinPoint);
    }
    @Around(DAO_POINT)
    public Object daoTimeAround(ProceedingJoinPoint joinPoint) {
        return this.timeAround(joinPoint);
    }

    @Around(WEB_POINT)
    public Object webTimeAround(ProceedingJoinPoint joinPoint) {
        return this.timeAround(joinPoint);
    }

    private Object timeAround(ProceedingJoinPoint joinPoint) {
        Object object = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        try {
            object = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("统计方法耗时出错", e);
        }
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        String methodName = signature.getName();

        this.printExecTime(methodName, startTime, endTime);
        return object;
    }

    private void printExecTime(String methodName, Long startTime, Long endTime) {
        long diff = endTime - startTime;
        logger.info("{}耗时： {}ms", methodName, diff);
    }
}
