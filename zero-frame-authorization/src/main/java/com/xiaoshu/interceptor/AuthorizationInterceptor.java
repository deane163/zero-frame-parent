package com.xiaoshu.interceptor;

import com.xiaoshu.annotation.Authorization;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description : 拦截器的 HandlerInterceptorAdapter
 * ---------------------------------
 * @Author : ubt.administrator
 * @Date : Create in 2018/10/20 11:13
 * <p/>
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("===============> interceprot ...");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod method = (HandlerMethod)handler;
        if( !method.getBean().getClass().isAnnotationPresent(Authorization.class)
                && !method.hasMethodAnnotation(Authorization.class) ){
            System.out.println("没有注解，直接跳过");
            return true;
        }
        // 拦截该注解，并进行返回操作。
        System.out.println("有该主机 Authorization，需要拦截进行处理");
        return true;
    }
}
