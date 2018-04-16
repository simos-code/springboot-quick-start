package com.simos.dao;

import com.simos.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by l2h on 18-4-16.
 * Desc: 用户表
 * @author l2h
 */
@Mapper
public interface UserMapper {
    /**
     * 添加用户
     * @param name　用户名
     * @param password　用户密码
     */
    @Insert("insert into user(name,password) values(#{name},#{password})")
    void addUser(@Param("name") String name,@Param("password") String password);

    /**
     * 查找用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findUserById(@Param("id") int id);
}
