package com.simos.decrypt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by l2h on 18-5-8.
 * Desc:配置类
 * @author l2h
 */
@Configuration
public class EnableDecryptPropertyConfiguration {
    @Bean
    public DecryptProperty decryptProperty(){
        return new AESDecryptProperty();
    }
    @Bean
    public EncryptPropertyChecker encryptPropertyChecker(){
        return new EncryptPropertyChecker("?#(",")?#");
    }
    @Bean
    public EncryptStringValueResolver encryptStringValueResolver(){
        return new SimosStringValueResolver(decryptProperty(),encryptPropertyChecker());
    }
    @Bean
    public SimosBeanFactoryPostProcessor simosBeanFactoryPostProcessor(ConfigurableEnvironment environment){
        return new SimosBeanFactoryPostProcessor(environment);
    }
}

