package com.innovation.demo.mapper;

import com.innovation.demo.pojo.Questionnaire;
import com.innovation.demo.pojo.Questionnaire_2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张以恒
 */
@Repository
@Mapper
public interface QuestionnaireMapper {

    /**
     * 保存问卷调查的结果
     *
     * @param questionnaire
     */
    void save(Questionnaire questionnaire);

    /**
     * 显示问卷信息
     *
     */
    List<Questionnaire_2> find_all();
}
