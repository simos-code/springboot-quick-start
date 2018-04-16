package com.simos.runner;

import com.simos.service.SystemInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by l2h on 18-4-16.
 * Desc: 系统启动完可以做一些业务操作
 * @author l2h
 */
@Component
@Order(1)
public class SimosApplicationRunner implements ApplicationRunner {
    @Autowired
    SystemInitService systemInitService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        systemInitService.systemInit();
    }
}
