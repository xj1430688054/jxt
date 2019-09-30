package com.gl.jxt.common.annotation;

import java.lang.annotation.*;

import com.gl.jxt.web.interceptor.TInterceptor;


@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Before {
    Class<? extends TInterceptor> value ();
}
