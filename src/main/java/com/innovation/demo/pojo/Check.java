package com.innovation.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Volerde
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Check {
    /**
     * 登录验证
     */
    private Boolean msgLogin;
    /**
     * 用户名
     */
    private String name;
    /**
     * 注册验证
     */
    private Boolean msgRegister;
    /**
     * 忘记密码验证
     */
    private Boolean msgReset;
    /**
     * 信息存储
     */
    private String msg;


}
