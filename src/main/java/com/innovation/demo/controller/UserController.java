package com.innovation.demo.controller;

import com.innovation.demo.mapper.UserMapper;
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
    public String register(@RequestParam("username")String username, @RequestParam("password") String password, @RequestParam("phonenumber") String phonenumber){
        User user = userMapper.selectUser(username);
        String msgRegister = "";
        if (user!=null){
            msgRegister ="false";//注册失败，用户已存在，返回false
        }else if (userMapper.saveUser(username, password, phonenumber)==1){
            msgRegister = "true";//注册成功，返回true
        }
        return msgRegister;
    }

    //登录功能
    @RequestMapping("/userlogin")
    @ResponseBody
    public String[] login(@RequestParam("yong") String yong, @RequestParam("mima") String mima) {
        User user = userMapper.selectUser(yong);
        String[] msg = {"",""};
        if (user==null|| !Objects.equals(mima, user.getPassword())){
            msg[0] = "false";//登录失败，用户名或密码错误，返回false
        }else {
            msg[0] = "true";//登陆成功，返回true
            msg[1] = yong;//yong即用户名，需要返回到index页面第84行的id为checkpoint的a标签中
        }
        return msg;
    }
    
    //忘记密码功能
    @RequestMapping("/resetPassword")
    @ResponseBody
    public String resetPwd(@RequestParam("phonenumber") String phonenumber, @RequestParam("username")String username,@RequestParam("password") String password) {
        User user = userMapper.selectUserByPhonenumber(phonenumber);
        String msgReset = "";
        if (user == null) {
            msgReset = "false";//找回失败，此手机号未进行注册,返回false
        } else{
            userMapper.resetPassword(password,phonenumber);
            msgReset = "true";//密码修改成功，返回true;
        }
        return msgReset;
    }
}

