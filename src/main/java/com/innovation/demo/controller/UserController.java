package com.innovation.demo.controller;

import com.fasterxml.jackson.databind.DatabindContext;
import com.innovation.demo.mapper.UserMapper;
import com.innovation.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //注册功能
    @RequestMapping("/register")
    public String register(@RequestParam("username")String username, @RequestParam("password") String password, @RequestParam("phonenumber") String phonenumber,HttpSession session){
        User user = userMapper.selectUser(username);
        if (user!=null){
            session.setAttribute("msgregister","注册失败，该用户已存在");
            return "redirect:/signup.html";
        }

        if (userMapper.saveUser(username, password, phonenumber)==0){
            return "/signup";
        } else {
        return "redirect:/login.html";
        }
    }


    //登录功能
    @RequestMapping("/userlogin")
    public String login(@RequestParam("yong") String yong, @RequestParam("mima") String mima, HttpSession session) {
        User user = userMapper.selectUser(yong);
        if (user==null|| !Objects.equals(mima, user.getPassword())){
            session.setAttribute("msglogin","用户名或密码错误");
            return "redirect:/login.html";
        }else {
            session.setAttribute("loginUser", yong);
            return "redirect:/index.html";
        }
    }
    //忘记密码功能
    @RequestMapping("/resetPassword")
    public String resetPwd(@RequestParam("phonenumber") String phonenumber, @RequestParam("username")String username,@RequestParam("password") String password, HttpSession session) {
        User user = userMapper.selectUserByPhonenumber(phonenumber);
        if (user == null) {
            session.setAttribute("msgResetPwd", "找回失败，此手机号未进行注册");
            return "redirect:/resetPwd.html";
        } else{
            userMapper.resetPassword(password,phonenumber);
            return "redirect:/login.html";
        }
    }
}

