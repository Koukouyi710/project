package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;



    @RequestMapping(value = "login",method = RequestMethod.GET)
    public  String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String login(UserInfo userInfo, HttpSession session){

       UserInfo loginUserInfo= userService.login(userInfo);

        System.out.println(loginUserInfo);

        if(loginUserInfo!=null){
            session.setAttribute(Const.CURRENT_USER,loginUserInfo);

            return "redirect:home";
        }
        return "login";
    }


    @RequestMapping("home")
    public  String  home(){

        return "home";
    }

    @RequestMapping("finduser")
    public  String  findAll(HttpSession session){

        List<UserInfo> userlist=userService.findAll();

        session.setAttribute("userlist",userlist);
        return "userlist";
    }

    @RequestMapping(value = "updateuser/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer userId, HttpServletRequest request){


        UserInfo user=userService.findUserById(userId);

        request.setAttribute("user",user);

        return "userupdate";
    }

    @RequestMapping(value = "updateuser/{id}",method = RequestMethod.POST)
    public  String  update(UserInfo user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GBK");

        //
        int count= userService.updateUser(user);

        if(count>0){
            //修改成功
            return "redirect:/user/finduser";
        }

        return "userupdate";
    }

    //删除用户
    @RequestMapping(value = "deleteuser/{id}",method = RequestMethod.GET)
    public  String  delete(@PathVariable("id") Integer userId, HttpServletRequest request){


        int user_result = userService.deleteUser(userId);

        return "redirect:/user/finduser";
    }

    //添加用户
    @RequestMapping(value = "useradd",method = RequestMethod.GET)
    public String addCategory(){
        return "useradd";
    }

    @RequestMapping(value = "useradd",method = RequestMethod.POST)
    public  String  addUser(UserInfo user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GBK");
        int count= userService.addUser(user);

        if(count>0){
            //添加成功
            return "redirect:/user/finduser";
        }

        return "useradd";
    }

}
