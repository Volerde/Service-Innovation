package com.innovation.demo.mapper;

import com.innovation.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Volerde
 */
@Repository
public interface UserMapper {

    /**
     * 注册成功，保存用户的用户名、密码、手机号到数据库
     *
     * @param username
     * @param password
     * @param phonenumber
     * @return
     */
    @Insert("insert into usermanager(username, password, phonenumber) VALUES (#{username},#{password},#{phonenumber})")
    int saveUser(@Param("username") String username, @Param("password") String password, @Param("phonenumber") String phonenumber);

    /**
     * 登录时验证该用户是否存在
     *
     * @param username
     * @return
     */
    @Select("select id,username,password,phonenumber from usermanager where username=#{username}")
    User selectUser(String username);

    /**
     * 忘记密码时通过手机号定位到该用户
     *
     * @param phonenumber
     * @param username
     * @return
     */
    @Select("select id,username,password,phonenumber from usermanager where phonenumber=#{phonenumber}&&username =#{username}")
    User selectUserByPhonenumber(String phonenumber, String username);

    /**
     * 修改密码
     *
     * @param password
     * @param phonenumber
     * @return
     */
    @Select("update usermanager set password= #{password} where phonenumber=#{phonenumber}")
    User resetPassword(String password, String phonenumber);
}
