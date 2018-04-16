package com.simos.connector;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by l2h on 18-3-30.
 * Desc: ssl配置
 * @author l2h
 */
@Configuration
public class TomcatConnectorConfiguration {
    //1.x的配置
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() throws Exception{
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.addAdditionalTomcatConnectors(createSslConnector());
//        return tomcat;
//    }
    //2.x的配置
    @Bean
    public ServletWebServerFactory servletContainer() throws Exception {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createNoSecureConnector());
        return tomcat;
    }
    private Connector createNoSecureConnector() throws  Exception {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setScheme("http");
        return connector;
    }
}
