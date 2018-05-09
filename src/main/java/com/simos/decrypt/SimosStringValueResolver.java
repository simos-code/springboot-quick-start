package com.simos.decrypt;

import org.springframework.util.StringValueResolver;

/**
 * Created by l2h on 18-5-8.
 * Desc:自定义解密实现
 * @author l2h
 */
public class SimosStringValueResolver  {

    private DecryptProperty decryptProperty;
    private EncryptPropertyChecker checker;
    public SimosStringValueResolver(DecryptProperty decryptProperty,EncryptPropertyChecker checker){
        this.decryptProperty = decryptProperty;
        this.checker = checker;
    }
    public String resolveStringValue(String source)  {
        try {
            if (checker.isEncryptInfo(source)){
                return decryptProperty.decrypt(checker.removePrefixSuffix(source));
            }
            return source;
        }
       catch (Exception ex){
          System.out.println(ex.getMessage());
       }
       return source;
    }

}
