package com.innovation.demo.controller;

import com.innovation.demo.mapper.QuestionnaireMapper;
import com.innovation.demo.pojo.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


/**
 * @author 张以恒
 * @create 2021/5/5-15:26
 **/
@Controller
public class QuestionnaireController {

    Date date = new Date();

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @PostMapping("/codes")
    public String  submit(Questionnaire questionnaire, Model model) {
        model.addAttribute("msg","提交成功");
        questionnaire.setBirth(date);
        questionnaireMapper.save(questionnaire);
        return "success";
    }
}