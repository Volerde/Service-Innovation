package com.innovation.demo.controller;

import com.innovation.demo.mapper.QuestionnaireMapper;
import com.innovation.demo.pojo.Questionnaire;
import com.innovation.demo.pojo.Questionnaire_2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/show")
    public String show_mysql(ModelMap modelMap) {
        List<Questionnaire_2> questionnaireList = questionnaireMapper.find_all();
        modelMap.addAttribute("questionnaireList",questionnaireList);
        return "show_sql";
    }
}