package com.innovation.demo.mapper;

import com.innovation.demo.pojo.Questionnaire;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 张以恒
 * @create 2021/5/5-15:27
 **/

@Repository
@Mapper
public interface QuestionnaireMapper {

    void save(Questionnaire questionnaire);
}
