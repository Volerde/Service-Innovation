package com.innovation.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String phonenumber;
}
