package com.simos;

import com.simos.controller.DateFormatFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;

/**
 * Created by l2h on 18-4-9.
 * Desc: 应用入口　main
 * @author l2h
 */
@SpringBootApplication
public class QuickStartApplication {
    public static void  main(String[]args){
        SpringApplication.run(QuickStartApplication.class,args);
    }
    @Bean
    public DateFormatFactoryBean dateFormat(){
        return new DateFormatFactoryBean();
    }
}
