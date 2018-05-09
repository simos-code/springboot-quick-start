package com.simos.decrypt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringValueResolver;

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
    public SimosStringValueResolver simosStringValueResolver(){
        return new SimosStringValueResolver(decryptProperty(),encryptPropertyChecker());
    }
    @Bean
    public SimosBeanFactoryPostProcessor simosBeanFactoryPostProcessor(ConfigurableEnvironment environment,
                                                                       StringValueResolver stringValueResolver){
        return new SimosBeanFactoryPostProcessor(environment,stringValueResolver);
    }
}

