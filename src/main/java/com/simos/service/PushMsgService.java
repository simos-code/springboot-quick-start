package com.simos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by l2h on 18-4-25.
 * Desc:消息推送业务逻辑类，调用消息推送组件．
 * @author l2h
 */
@Service
public class PushMsgService {
    @Autowired
    LookupPushMsgPool pushMsgPool;
    @Autowired
    AwarePushMsgPool awarePushMsgPool;

    /**
     * 业务功能需要消息推送
     * @param msg　需要推送的内容
     */
    public void pushMsg(String msg){
        /**
         * 业务处理
         */
        /**
         * 处理后后推送
         */
        pushMsgPool.pushMsg("lookup:"+msg);
        awarePushMsgPool.pushMsg("aware:"+msg);
    }
}
