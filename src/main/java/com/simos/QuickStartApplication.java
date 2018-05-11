package com.simos;

import com.simos.controller.DateFormatFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    @Bean
    public DemoService firstDemo(){
        return new DemoService();
    }
    @Bean
    public DemoService secondDemo(){
        return new DemoService();
    }
}
