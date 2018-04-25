package com.simos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * Created by l2h on 18-4-25.
 * Desc: 推送消息任务
 * @author l2h
 */
@Service("task")
@Scope(SCOPE_PROTOTYPE)
public class PushMsgTask implements  Runnable{
    private String msg ;
    public PushMsgTask(){
    }
    public PushMsgTask(String msg){
        this.msg = msg;
    }
    @Autowired
    PushService pushService;
    @Override
    public void run() {
        pushService.pushMsg(msg);
    }
    public void  setMsg(String msg){
        this.msg = msg;
    }
}
