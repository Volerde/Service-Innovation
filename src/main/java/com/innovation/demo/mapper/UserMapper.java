package com.innovation.demo.mapper;

import com.innovation.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Insert("insert into usermanager(username, password, phonenumber) VALUES (#{username},#{password},#{phonenumber})")
    int saveUser(@Param("username") String username, @Param("password") String password, @Param("phonenumber") String phonenumber);

    @Select("select id,username,password,phonenumber from usermanager where username=#{username}")
    User selectUser(String username);

    @Select("select id,username,password,phonenumber from usermanager where phonenumber=#{phonenumber}&&username =#{username}")
    User selectUserByPhonenumber(String phonenumber,String username);

    @Select("update usermanager set password= #{password} where phonenumber=#{phonenumber}")
    User resetPassword(String password,String phonenumber);
}
