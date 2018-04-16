package com.simos.controller;

import com.simos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by l2h on 18-4-16.
 * Desc:用户相关请求处理
 * @author l2h
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name, @RequestParam("password") String password){
        if ( StringUtils.isEmpty(name)){
            //实际生产环境，不建议这么使用．应该自定义一个统一的返回结果数据格式｛data:"json业务数据",msg："结果说明",code:"状态码"｝
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(password)){
            return "密码不能为空";
        }
        userService.addUser(name, password);
        return "成功";
    }
}
