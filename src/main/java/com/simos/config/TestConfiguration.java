package com.simos.config;

import com.simos.bean.BeanTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by l2h on 18-4-12.
 * Desc:配置类.用来说明EnableAutoConfiguration
 * @author l2h
 */
@Configuration
public class TestConfiguration {
    @Bean(name = "beanTestConfig")
    public BeanTest beanTestConfig(){
        return new BeanTest();
    }
}
