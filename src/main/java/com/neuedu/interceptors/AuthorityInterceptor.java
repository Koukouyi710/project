package com.neuedu.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthorityInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("=====preHandle======");
        HttpSession session = request.getSession();
        if (session.getAttribute("user")!=null){
            return true;
        }
        else {
            try {
            response.sendRedirect(request.getContextPath()+"/user/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;//false:拦截请求 true:不会拦截请求
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("=====postHandle======");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("=====afterCompletion======");
    }

}
