package com.simos.decrypt;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
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
    /**
     * 应用环境，用于获取配置属性
     */
    private ConfigurableEnvironment environment;
    private BeanFactory beanFactory;
    /**
     * 完成解密的接口
     */
    private SimosStringValueResolver valueResolver;
    public SimosBeanFactoryPostProcessor(ConfigurableEnvironment environment ,SimosStringValueResolver stringValueResolver){
        this.environment = environment;
        this.valueResolver = stringValueResolver;
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactoryToProcess) throws BeansException {
        String[] beanNames = beanFactoryToProcess.getBeanDefinitionNames();
        for (String curName : beanNames) {
            // Check that we're not parsing our own bean definition,
            // to avoid failing on unresolvable placeholders in properties file locations.
            if (!(curName.equals(this.beanName) && beanFactory.equals(this.beanFactory))) {
                /**
                 * 获取所有配置属性
                 */
                MutablePropertySources propertyValues =  environment.getPropertySources();
                decryptProperty(propertyValues,valueResolver);
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

    /**
     * 解密方法．遍历每个PropertySources，遍历PropertySources的每个键值如果包含加密信息就解密，最后替换．
     * @param propertyValues
     * @param valueResolver
     */
    private void decryptProperty(MutablePropertySources propertyValues,SimosStringValueResolver valueResolver) {
        propertyValues.forEach(pv->{
            PropertySource propertySource = propertyValues.get(pv.getName());
            if (propertySource instanceof MapPropertySource){
                //保存处理过后的值
                Map<String,Object> convertPropertySource = new HashMap<>();
                //重新定义一个PropertySource，覆盖原来的
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
                //处理过后值替换原来的PropertySource
                propertyValues.replace(pv.getName(),newMapPropertySource);
            }

        });

    }
}
