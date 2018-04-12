package com.simos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by l2h on 18-4-12.
 * Desc:能够被@ComponentScan扫描
 * @author l2h
 */
@RestController
public class OutPackageController {
    @RequestMapping(value = "/out",method = RequestMethod.GET)
    public String test(){
        return "out!";
    }
}
