package com.simos.controller;

import com.simos.service.PushMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by l2h on 18-4-25.
 * Desc:模拟调用消息推送
 * @author l2h
 */
@RestController
public class PushMsgController {
    @Autowired
    PushMsgService service;
    @GetMapping("/mockpush")
    public String mockPushMsg(@RequestParam("msg")String msg){
        service.pushMsg(msg);
        return "success";
    }
}
