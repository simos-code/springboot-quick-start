package com.simos.decrypt;

/**
 * Created by l2h on 18-5-11.
 * Desc:　提供给BeanFactoryPostProcessor解密接口
 * @author l2h
 */
public interface EncryptStringValueResolver {
    /**
     * 提供给BeanFactoryPostProcessor解密接口
     * @param source
     * @return
     */
    String resolveEncryptStringValue(String source);
}
