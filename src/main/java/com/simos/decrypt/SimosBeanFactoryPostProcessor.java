package com.simos.decrypt;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringValueResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by l2h on 18-5-8.
 * Desc:BeanFactoryPostProcessor完成配置文件中属性解密
 * @author l2h
 */
public class SimosBeanFactoryPostProcessor implements BeanFactoryPostProcessor,BeanNameAware,BeanFactoryAware,Ordered {
    private String beanName;
    private ConfigurableEnvironment environment;
    private BeanFactory beanFactory;
    private StringValueResolver valueResolver;
    public SimosBeanFactoryPostProcessor(ConfigurableEnvironment environment ,StringValueResolver stringValueResolver){
        this.environment = environment;
        this.valueResolver = stringValueResolver;
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactoryToProcess) throws BeansException {
        BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
        String[] beanNames = beanFactoryToProcess.getBeanDefinitionNames();
        for (String curName : beanNames) {
            // Check that we're not parsing our own bean definition,
            // to avoid failing on unresolvable placeholders in properties file locations.
            if (!(curName.equals(this.beanName) && beanFactory.equals(this.beanFactory))) {
                BeanDefinition bd = beanFactoryToProcess.getBeanDefinition(curName);
                MutablePropertySources propertyValues =  environment.getPropertySources();
                decryptProperty(propertyValues,valueResolver);
                try {
                    visitor.visitBeanDefinition(bd);
                }
                catch (Exception ex) {
                    throw new BeanDefinitionStoreException(bd.getResourceDescription(), curName, ex.getMessage(), ex);
                }
            }
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
    private void decryptProperty(MutablePropertySources propertyValues,StringValueResolver valueResolver) {
        propertyValues.forEach(pv->{
            PropertySource propertySource = propertyValues.get(pv.getName());
            if (propertySource instanceof MapPropertySource){
                Map<String,Object> convertPropertySource = new HashMap<>();
                MapPropertySource newMapPropertySource = new MapPropertySource(pv.getName(),convertPropertySource);
                String[] propertyNames = ((MapPropertySource) propertySource).getPropertyNames();
                for (int i=0,length = propertyNames.length;i<length;i++){
                   Object value = propertySource.getProperty(propertyNames[i]);
                   if (value instanceof String){
                       convertPropertySource.put(propertyNames[i], valueResolver.resolveStringValue((String) value));
                   }
                   else {
                       convertPropertySource.put(propertyNames[i],value);
                   }
                }
                propertyValues.replace(pv.getName(),newMapPropertySource);
            }

        });

    }
}
