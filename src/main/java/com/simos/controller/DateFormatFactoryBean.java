package com.simos.controller;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.Ordered;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Created by l2h on 18-5-9.
 * Desc: 日期格式化bean的ＦactoryBean
 * @author l2h
 */

public class DateFormatFactoryBean implements FactoryBean<DateFormat>,InitializingBean,Ordered{
    private DateFormat dateFormat;

    @Override
    public void afterPropertiesSet() throws Exception {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.SHORT_IDS.get("CTT")));
    }

    @Override
    public DateFormat getObject() throws Exception {
        return dateFormat;
    }

    @Override
    public Class<?> getObjectType() {
        return dateFormat.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
