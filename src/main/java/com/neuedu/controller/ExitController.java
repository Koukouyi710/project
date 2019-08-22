package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ExitController {

    @RequestMapping("/exit")
    /*@CookieValue("username")Cookie username_cookie,@CookieValue("password")Cookie password_cookie*/
    public String exit(HttpServletRequest request, HttpServletResponse response){
        Cookie username_cookie = new Cookie("username",null);
        Cookie password_cookie = new Cookie("password",null);
        password_cookie.setMaxAge(0);
        password_cookie.setPath("/project/user/");
        response.addCookie(password_cookie);
        username_cookie.setMaxAge(0);
        username_cookie.setPath("/project/user/");
        response.addCookie(username_cookie);

        Cookie username_cookie_qq = new Cookie("username",null);
        Cookie password_cookie_qq = new Cookie("password",null);
        password_cookie_qq.setMaxAge(0);
        password_cookie_qq.setPath("/project/user");
        response.addCookie(password_cookie_qq);
        username_cookie_qq.setMaxAge(0);
        username_cookie_qq.setPath("/project/user");
        response.addCookie(username_cookie_qq);

        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/user/login";
    }
}
