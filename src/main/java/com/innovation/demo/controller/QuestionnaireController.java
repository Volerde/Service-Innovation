package com.innovation.demo.controller;

import com.innovation.demo.mapper.QuestionnaireMapper;
import com.innovation.demo.pojo.Questionnaire;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

/**
 * @author 张以恒
 */
@Controller
public class QuestionnaireController {

    Date date = new Date();

    private final QuestionnaireMapper questionnaireMapper;

    public QuestionnaireController(QuestionnaireMapper questionnaireMapper) {
        this.questionnaireMapper = questionnaireMapper;
    }

    /**
     * @param questionnaire
     * @param model
     * @return
     */
    @PostMapping("/codes")
    public String submit(Questionnaire questionnaire, Model model) {
        model.addAttribute("msg", "提交成功");
        questionnaire.setBirth(date);
        questionnaireMapper.save(questionnaire);
        return "success";
    }
}