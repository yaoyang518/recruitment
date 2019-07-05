package com.yaoyang.recruitment.aop;

import com.yaoyang.recruitment.annotation.FilterRequest;
import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.entity.Admin;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.enumeration.Role;
import com.yaoyang.recruitment.service.AdminService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author yaoyang 2018/12/26 4:15 PM
 */
@Aspect
@Component
public class AspectRequest {

    private static Logger logger= LoggerFactory.getLogger(AspectRequest.class);

    @Autowired
    private AdminService adminService;

    @Pointcut("execution(public * com.yaoyang.recruitment.controller.*.*(..)))")
    public void log() {
    }

    @Around("log()")
    public Object validatePermission(ProceedingJoinPoint point) throws Throwable {
        try {
            Class carClass = point.getTarget().getClass();
            String methodName = point.getSignature().getName();
            Method[] methods = carClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals(methodName)) {
                    boolean hasAnnotation = methods[i].isAnnotationPresent(FilterRequest.class);
                    if (hasAnnotation) {
                        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                        HttpServletRequest request = sra.getRequest();
                        logger.info("class_method:" + point.getSignature().getDeclaringTypeName() + "."
                                + point.getSignature().getName());
                        Object[] args = point.getArgs();
//                        for (Object arg : args) {
//                            logger.info("arg:" + arg.toString());
//                        }

                        FilterRequest filterRequest = methods[i].getAnnotation(FilterRequest.class);
                        String role = filterRequest.role();
                        if ("WRITE".equalsIgnoreCase(role)) {
                            String token = request.getHeader("x-access-token");
                            ApiResult<Admin> result = adminService.validateToken(token);
                            if (!result.isSuccess()) {
                                return result;
                            }
                            Admin admin = result.getData();
                            if(admin.getRole().equals(Role.READ)){
                                return ApiResultBuilder.buildFailedResult(ResponseCode.PERMISSION_DENY);
                            }
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.TOKEN_ERROR);
        }
        return point.proceed();
    }
}
