package cn.edu.whu.managesystem.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/13
 */
public class FutureUtils {
    private static final Logger logger = LoggerFactory.getLogger(FutureUtils.class);
    public static Integer getFutureValue(String methodName, Future<Integer> future) {
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            logger.info(methodName + "interrupt: ", e);
        } catch (ExecutionException e) {
            logger.info(methodName + "execute exception: ", e);
        }
        return result;
    }
}
