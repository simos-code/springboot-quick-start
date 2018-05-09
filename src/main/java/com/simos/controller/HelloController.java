package com.simos.controller;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${demo.encryptinfo}")
    private String demo;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello()throws Exception{
        System.out.println(demo);
        return "hello world!";
    }
}
