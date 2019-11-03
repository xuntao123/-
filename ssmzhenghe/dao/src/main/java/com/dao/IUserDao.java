package com.dao;

import com.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

   /* @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",javaType = java.util.List.class,column = "id",many = @Many(select = "com.dao.IRoleDao.findRoleByUserId"))
    })*/
   @Select("select * from users where username=#{username}")
    public UserInfo findByUsername(String username) ;
    @Select("select * from users")
    List<UserInfo> findAll();
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles", column = "id",javaType = java.util.List.class,many = @Many(select = "com.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id);
}
