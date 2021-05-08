package com.innovation.demo.controller;

import com.innovation.demo.mapper.UserMapper;
import com.innovation.demo.pojo.User;
import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //注册功能
    //施工ing：前端验证部分
    @RequestMapping("/register")
    public String register(@RequestParam("username")String username, @RequestParam("password") String password, @RequestParam("phonenumber") String phonenumber,HttpSession session){
        User user = userMapper.selectUser(username);
        if (user!=null){
            session.setAttribute("msg","注册失败，该用户已存在");
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
    public String login(@RequestParam("yong") String yong,@RequestParam("mima") String mima,HttpSession session) {
        User user = userMapper.selectUser(yong);
        if (user==null){
            session.setAttribute("msg","登录失败，该用户不存在");
            return "redirect:/login.html";
        }

        if (Objects.equals(mima,user.getPassword())){
            session.setAttribute("loginUser",yong);
            return "redirect:/index";
        }else {
            session.setAttribute("msg","登录失败，密码错误");
            return "redirect:/login.html";
        }
    }
}
