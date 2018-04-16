package com.simos.service;

import com.simos.dao.UserMapper;
import com.simos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by l2h on 18-4-16.
 * Desc:用户处理业务类
 * @author l2h
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 添加用户
     * @param name　用户名
     * @param pass　密码．实际使用时候需要加密保存
     */
    public void addUser(String name,String pass){
        userMapper.addUser(name,pass);
    }
    public User findUserById(int id){
        return userMapper.findUserById(id);
    }
}
