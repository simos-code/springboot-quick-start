package com.simos.service;

import org.springframework.stereotype.Service;

/**
 * Created by l2h on 18-4-16.
 * Desc:系统初始化后执行一些业务操作
 * @author l2h
 */
@Service
public class SystemInitService {
    public void systemInit(){
        System.out.println("应用初始化后，进行一些业务操作，如启动某些工作线程，初始化系统某些参数");
    }
}
