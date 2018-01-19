package cn.edu.whu.managesystem.utils.result;

import org.springframework.stereotype.Component;

/**
 * @author jamesli
 * @email 984664077@qq.com
 * @date 2018/1/6
 */
@Component
public class ResultGenerator {
    private static final String SUCCESS_MESSAGE = "SUCCESS";
    private static final String ERROR_MESSAGE = "ERROR";

    private static final Integer SUCCESS = 200;
    private static final Integer FAIL = 400;
    private static final Integer UNAUTHORIZED = 401;
    private static final Integer NOT_FOUND = 404;
    private static final Integer INTERNAL_SERVER_ERROR = 500;

    public static Result generateSuccessResult() {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setMessage(SUCCESS_MESSAGE);
        return result;
    }

    public static Result generateSuccessResult(Object object) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setMessage(SUCCESS_MESSAGE);
        result.setData(object);
        return result;
    }

    public static Result generateFailResult() {
        Result result = new Result();
        result.setCode(FAIL);
        result.setMessage(ERROR_MESSAGE);
        return result;
    }

    public static Result generateFailResult(Object object) {
        Result result = new Result();
        result.setCode(FAIL);
        result.setData(object);
        result.setMessage(ERROR_MESSAGE);
        return result;
    }

    public static Result generateUnAuthorizedResult() {
        Result result = new Result();
        result.setCode(UNAUTHORIZED);
        result.setMessage(ERROR_MESSAGE);
        return result;
    }
}
