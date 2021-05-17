package com.innovation.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张以恒
 * @create 2021/5/5-15:28
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {

    /*private long id;*/
    private String  sex;
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

    @Override
    public String toString() {
        return "Questionnaire{" +
                "sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", job='" + job + '\'' +
                ", salary='" + salary + '\'' +
                ", experience='" + experience + '\'' +
                ", activities='" + activities + '\'' +
                ", hoping='" + hoping + '\'' +
                ", buy='" + buy + '\'' +
                ", types='" + types + '\'' +
                ", know='" + know + '\'' +
                ", spend='" + spend + '\'' +
                ", collection='" + collection + '\'' +
                ", advice='" + advice + '\'' +
                ", birth=" + birth +
                '}';
    }
}