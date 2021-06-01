package com.innovation.demo.controller;

import com.innovation.demo.mapper.UserMapper;
import com.innovation.demo.pojo.Check;
import com.innovation.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author Volerde
 */
@Controller
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 注册功能
     *
     * @param username
     * @param password
     * @param phonenumber
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Check register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("phonenumber") String phonenumber) {
        User user = userMapper.selectUser(username);
        Check check = new Check();
        if (user != null) {
            //注册失败，用户已存在，返回false
            check.setMsgRegister(false);
            check.setMsg("注册失败，用户已存在");
        } else if (userMapper.saveUser(username, password, phonenumber) == 1) {
            //注册成功，返回true
            check.setMsgRegister(true);
        }
        return check;
    }

    /**
     * 登录功能
     *
     * @param yong
     * @param mima
     * @return
     */
    @RequestMapping("/userlogin")
    @ResponseBody
    public Check login(@RequestParam("yong") String yong, @RequestParam("mima") String mima, HttpSession session) {
        User user = userMapper.selectUser(yong);
        Check check = new Check();
        if (user == null || !Objects.equals(mima, user.getPassword())) {
            //登录失败，用户名或密码错误，返回false
            check.setMsgLogin(false);
            check.setMsg("登录失败，用户名或密码错误");
        } else {
            //登陆成功，返回true
            check.setMsgLogin(true);
            session.setAttribute("loginUser",yong);
            //yong即用户名，需要返回到index页面第84行的id为checkpoint的a标签中
            check.setName(yong);
        }
        return check;
    }

    /**
     * 忘记密码功能
     *
     * @param phonenumber
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/resetPassword")
    @ResponseBody
    public Check resetPwd(@RequestParam("phonenumber") String phonenumber, @RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userMapper.selectUserByPhonenumber(phonenumber, username);
        Check check = new Check();
        if (user == null) {
            //找回失败，此手机号未进行注册或用户名未找到,返回false
            check.setMsgReset(false);
            check.setMsg("找回失败，此手机号未进行注册或用户名未找到");
        } else {
            userMapper.resetPassword(password, phonenumber);
            //密码修改成功，返回true;
            check.setMsgReset(true);
        }
        return check;
    }
}

