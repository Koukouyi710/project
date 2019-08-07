package com.neuedu.interceptors;

import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthorityInterceptor implements HandlerInterceptor{

    @Autowired
    IUserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("=====preHandle======");
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies!=null&&cookies.length>0){
            for (Cookie c:cookies){
                if (c.getName().equals("username")){
                    username = c.getValue();
                }
                if (c.getName().equals("password")){
                    username = c.getValue();
                }
            }
        }
        if (session.getAttribute("user")!=null){
            return true;
        }
        else if (username!=null&&password!=null){
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
