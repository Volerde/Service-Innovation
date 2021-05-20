package com.innovation.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 张以恒
 * @create 2021/5/4-13:23
 **/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/about.html").setViewName("about");
        registry.addViewController("/codes.html").setViewName("codes");
        registry.addViewController("/gallery.html").setViewName("gallery");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/services.html").setViewName("services");
        registry.addViewController("/consultation.html").setViewName("consultation");
        registry.addViewController("/lease.html").setViewName("lease");
        registry.addViewController("/customize.html").setViewName("customize");
        registry.addViewController("/help.html").setViewName("help");
        registry.addViewController("/collection.html").setViewName("collection");
        registry.addViewController("/update.html").setViewName("update");
        registry.addViewController("/application.html").setViewName("application");
        registry.addViewController("/integral.html").setViewName("integral");
        registry.addViewController("/orders.html").setViewName("orders");
        registry.addViewController("/special.html").setViewName("special");
        registry.addViewController("/signup.html").setViewName("signup");
        registry.addViewController("/resetPwd.html").setViewName("resetPwd");
        registry.addViewController("/success.html").setViewName("success");
    }
}