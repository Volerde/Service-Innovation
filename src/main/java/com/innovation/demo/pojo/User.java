package com.innovation.demo.pojo;

import lombok.Data;
import java.io.Serializable;

/**
 * @author Volerde
 */
@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String phonenumber;
}
