package com.simos.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by l2h on 18-4-17.
 * Desc:　自定义日志级别打印，测试类
 * @author l2h
 */
@RestController
public class LogController {
    private final Logger logger =  LogManager.getLogger(LogController.class);
    private final Level BU_TWO_INFO = Level.forName("BU_TWO_INFO",480);
    private final Level BU_ONE_INFO = Level.forName("BU_ONE_INFO",490);
    @GetMapping("/log")
    public String log(@RequestParam("msg")String msg){
        logger.log(BU_ONE_INFO,msg);
        logger.log(BU_TWO_INFO,msg);
        logger.info(msg);
        logger.error(msg);
        logger.warn(msg);
        return "success";
    }
}
