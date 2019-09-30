package com.gl.jxt.web.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gl.jxt.common.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InitInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler != null) {
            List<Annotation> annotationList = new ArrayList<>();
            if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                Class clazz = ((HandlerMethod) handler).getMethod().getDeclaringClass();
                Annotation[] classAnnotations = clazz.getAnnotations();
                for (Annotation annotation : classAnnotations) {
                    annotationList.add(annotation);
                }
                Annotation[] methodAnnotations = ((HandlerMethod) handler).getMethod().getAnnotations();
                for (Annotation annotation : methodAnnotations) {
                    annotationList.add(annotation);
                }
                for (int i = 0; i < annotationList.size(); i++) {
                    boolean hasClear = false;
                    Annotation annotation = annotationList.get(i);
                    //获取Before注解
                    Before before = null;
                    try {
                        before = (Before) annotation;
                    } catch (Exception e) {

                    }
                    if (before != null) {
                        for (int j = i + 1; j < annotationList.size(); j++) {
                            Annotation annotation1 = annotationList.get(j);
                            Clear clear = null;
                            try {
                                clear = (Clear) annotation1;
                            } catch (Exception e) {

                            }
                            if (clear != null) {
                                hasClear = true;
                                break;
                            }
                        }
                        //在@Before注解后面如果有@Clear注解，该注解就无效
                        if (!hasClear) {
                            Class<? extends TInterceptor> interceptorlll = before.value();
                            Object object = Class.forName(interceptorlll.getCanonicalName()).newInstance();
                            Class[] clazzs = new Class[]{HttpServletRequest.class, HttpServletResponse.class, Object.class};
                            Method method = object.getClass().getMethod("interceptor", clazzs);
                            Object[] params = new Object[]{request, response, handler};
                            boolean result = (boolean) method.invoke(object, params);
                            return result;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (handler != null) {
            List<Annotation> annotationList = new ArrayList<>();
            if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                Class clazz = ((HandlerMethod) handler).getMethod().getDeclaringClass();
                Annotation[] classAnnotations = clazz.getAnnotations();
                for (Annotation annotation : classAnnotations) {
                    annotationList.add(annotation);
                }
                Annotation[] methodAnnotations = ((HandlerMethod) handler).getMethod().getAnnotations();
                for (Annotation annotation : methodAnnotations) {
                    annotationList.add(annotation);
                }
                for (int i = 0; i < annotationList.size(); i++) {
                    boolean hasClear = false;
                    Annotation annotation = annotationList.get(i);
                    //获取After注解
                    After after = null;
                    try {
                        after = (After) annotation;
                    } catch (Exception e1) {

                    }
                    if (after != null) {
                        for (int j = i + 1; j < annotationList.size(); j++) {
                            Annotation annotation1 = annotationList.get(j);
                            Clear clear = null;
                            try {
                                clear = (Clear) annotation1;
                            } catch (Exception e1) {

                            }
                            if (clear != null) {
                                hasClear = true;
                                break;
                            }
                        }
                        //在@After注解后面如果有@Clear注解，该注解就无效
                        if (!hasClear) {
                            Class<? extends TInterceptor> interceptorlll = after.value();
                            Object object = Class.forName(interceptorlll.getCanonicalName()).newInstance();
                            Class[] clazzs = new Class[]{HttpServletRequest.class, HttpServletResponse.class, Object.class};
                            Method method = object.getClass().getMethod("interceptor", clazzs);
                            Object[] params = new Object[]{request, response, handler};
                            method.invoke(object, params);
                        }
                    }
                }
            }
        }
    }
}
