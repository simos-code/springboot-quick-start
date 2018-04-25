package com.simos.controller;

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
    private LogController logController;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world!";
    }
    public HelloController(LogController logController){
        this.logController = logController;
    }
    public void setLogController(LogController logController){
        this.logController = logController;
    }

}
