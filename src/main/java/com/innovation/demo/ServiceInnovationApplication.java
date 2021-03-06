package com.innovation.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Volerde
 */
@MapperScan("com.innovation.demo.mapper")
@SpringBootApplication
public class ServiceInnovationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceInnovationApplication.class, args);
    }

}
