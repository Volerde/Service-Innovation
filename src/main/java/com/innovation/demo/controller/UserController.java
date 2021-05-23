package com.innovation.demo.controller;

import com.innovation.demo.mapper.UserMapper;
import com.innovation.demo.pojo.Check;
import com.innovation.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;
    //注册功能
    @RequestMapping("/register")
    @ResponseBody
    public Check register(@RequestParam("username")String username, @RequestParam("password") String password, @RequestParam("phonenumber") String phonenumber){
        User user = userMapper.selectUser(username);
        Check check = new Check();
        if (user!=null){
            check.setMsgRegister(false);//注册失败，用户已存在，返回false
            check.setMsg("注册失败，用户已存在");
        }else if (userMapper.saveUser(username, password, phonenumber)==1){
            check.setMsgRegister(true);//注册成功，返回true
        }
        return check;
    }

    //登录功能
    @RequestMapping("/userlogin")
    @ResponseBody
    public Check login(@RequestParam("yong") String yong, @RequestParam("mima") String mima) {
        User user = userMapper.selectUser(yong);
        Check check = new Check();
        if (user==null|| !Objects.equals(mima, user.getPassword())){
            check.setMsgLogin(false);//登录失败，用户名或密码错误，返回false
            check.setMsg("登录失败，用户名或密码错误");
        }else {
            check.setMsgLogin(true);//登陆成功，返回true
            check.setName(yong);//yong即用户名，需要返回到index页面第84行的id为checkpoint的a标签中
        }
        return check;
    }

    //忘记密码功能
    @RequestMapping("/resetPassword")
    @ResponseBody
    public Check resetPwd(@RequestParam("phonenumber") String phonenumber, @RequestParam("username")String username,@RequestParam("password") String password) {
        User user = userMapper.selectUserByPhonenumber(phonenumber,username);
        Check check = new Check();
        if (user == null) {
            check.setMsgReset(false);//找回失败，此手机号未进行注册或用户名未找到,返回false
            check.setMsg("找回失败，此手机号未进行注册或用户名未找到");
        } else{
            userMapper.resetPassword(password,phonenumber);
            check.setMsgReset(true);//密码修改成功，返回true;
        }
        return check;
    }
}

