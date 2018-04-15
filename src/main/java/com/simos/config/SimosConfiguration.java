package com.simos.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by l2h on 18-4-15.
 * Desc:
 */
@Configuration
@EnableConfigurationProperties(SimosProperties.class)
public class SimosConfiguration {

    private final SimosProperties simosProperties;
    public SimosConfiguration(SimosProperties simosProperties){
        this.simosProperties = simosProperties;
    }
    public SimosProperties getSimosProperties(){
        return simosProperties;
    }
}
