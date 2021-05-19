package com.innovation.demo.mapper;

import com.innovation.demo.pojo.Questionnaire;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface QuestionnaireMapper {

    void save(Questionnaire questionnaire);
}
