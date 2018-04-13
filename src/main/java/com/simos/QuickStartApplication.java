package com.simos;

import com.simos.bean.BeanTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created by l2h on 18-4-9.
 * Desc: 应用入口　main
 * @author l2h
 */
@SpringBootApplication(exclude = MongoDataAutoConfiguration.class)
public class QuickStartApplication {
    public static void  main(String[]args){
        SpringApplication.run(QuickStartApplication.class,args);
    }
    @Bean
    public BeanTest beanTest(){
        return  new BeanTest();
    }
}
