package com.neuedu.service.impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService{

    @Autowired
    UserInfoMapper userInfoMapper;

    //======登录功能======
    @Override
    public UserInfo login(UserInfo userInfo) throws MyException {


        //1、参数的非空校验

        if(userInfo==null){
            throw new MyException("参数不能为空！");
        }
        if (userInfo.getUsername()==null||userInfo.getUsername().equals("")){
            throw new MyException("用户名不能为空！");
        }
        if (userInfo.getPassword()==null||userInfo.getPassword().equals("")){
            throw new MyException("密码不能为空！");
        }


        //2、判断用户名是否存在

        int username_result = userInfoMapper.exsitsUsername(userInfo.getUsername());

        if (username_result==0) {//用户名不存在
            throw new MyException("用户名不存在！");
        }

        //3、根据用户名和密码登录

        UserInfo userInfo_result = userInfoMapper.findByUsernameAndPassword(userInfo);
        if (userInfo_result==null){
            throw new MyException("用户名或密码错误！");
        }

        //4、判断权限

        if(userInfo_result.getRole()!=0){//不是管理员
            throw new MyException("很抱歉！您不是管理员，不能登录后台管理系统！");
        }



        return userInfo_result;
    }
}
