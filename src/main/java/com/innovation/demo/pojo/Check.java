package com.innovation.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Check {
    private Boolean msgLogin;//登录验证
    private String name;//用户名
    private Boolean msgRegister;//注册验证
    private Boolean msgReset;//忘记密码验证
    private String msg;//信息存储


}
