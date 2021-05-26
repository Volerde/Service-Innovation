package com.innovation.demo.mapper;

import com.innovation.demo.pojo.Questionnaire;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
