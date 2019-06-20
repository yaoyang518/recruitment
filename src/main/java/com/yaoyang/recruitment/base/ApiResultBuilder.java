package com.yaoyang.recruitment.base;

import com.yaoyang.recruitment.enumeration.ResponseCode;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据接口返回信息构建
 *
 * @author zhangsl
 * @date 2018-01-24
 */
public class ApiResultBuilder {

    public static <T> ApiResult<T> buildSuccessResult(ResponseCode code) {
        return buildSuccessResult(code, null);
    }

    public static <T> ApiResult<T> buildSuccessResult(ResponseCode code, T t) {
        ApiResult<T> result = new ApiResult<T>();
        result.setSuccess(true);
        result.setCode(code.getCode());
        result.setMessage(code.getMessage());
        if (t != null) {
            result.setData(t);
        }
        return result;
    }

    public static ApiResult buildFailedResult(List<ObjectError> errors) {
        List<String> list = new ArrayList<>();
        for (ObjectError error : errors) {
            list.add(error.getDefaultMessage());
        }
        ApiResult result = buildFailedResult(ResponseCode.PARAM_ILLEGAL, list);
        result.setMessage(list.toString());
        return result;
    }

    public static <T> ApiResult<T> buildFailedResult(ResponseCode code) {
        return buildFailedResult(code, null);
    }

    public static <T> ApiResult<T> buildFailedResult(ResponseCode code, T t) {
        ApiResult<T> result = new ApiResult<T>();
        result.setSuccess(false);
        result.setCode(code.getCode());
        result.setMessage(code.getMessage());
        if (t != null) {
            result.setData(t);
        }
        return result;
    }
}
