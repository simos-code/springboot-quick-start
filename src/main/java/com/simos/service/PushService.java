package com.simos.service;

import org.springframework.stereotype.Service;

/**
 * Created by l2h on 18-4-25.
 * Desc:模拟真正实现推送功能的底层类
 * @author l2h
 */
@Service
public class PushService {
    public void pushMsg(String msg){
        System.out.println(msg);
    }
}
