package com.simos.controller;

import com.simos.config.SimosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by l2h on 18-4-15.
 * Desc:
 */
@RestController
public class ConfigPropertiesController {
    @Autowired
    SimosProperties properties;
    @Value("${simos.name}")
    private String name;
    @Value("${simos.age}")
    private int age;
    @Value("${simos.bodyWeight}")
    private double bodyWeight;
    @Value("${simos.girlFriend.beautiful}")
    private Boolean beautiful;
    @RequestMapping(value = "/config",method = RequestMethod.GET)
    public String getConfigProperties(){
        return "{name:"+name+",age:"+age+",beautiful:"+beautiful+",bodyWeight:"+bodyWeight+"}";
    }
    @RequestMapping(value = "/simos",method = RequestMethod.GET)
    public SimosProperties getSimosProperties(){
        return properties ;
    }
}
