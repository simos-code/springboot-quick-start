package com.simos.controller;

import com.simos.bean.BeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by l2h on 18-4-9.
 * Desc: hello world
 * @author l2h
 */
@RestController
public class HelloController {
    @Autowired
    BeanTest beanTest;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world!";
    }
    @RequestMapping(value = "/beantest",method = RequestMethod.GET)
    public String beanTest(){
        return "beanTest!";
    }
}
