package com.innovation.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author 张以恒
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Questionnaire {

    private String sex;
    private String age;
    private String job;
    private String salary;
    private String experience;
    private String activities;
    private String hoping;
    private String buy;
    private String types;
    private String know;
    private String spend;
    private String collection;
    private String advice;
    private Date birth;

}