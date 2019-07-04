package com.yaoyang.recruitment.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FilterRequest {

    String role() default "";
}
