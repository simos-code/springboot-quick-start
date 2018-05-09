package com.simos.decrypt;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * Created by l2h on 18-5-8.
 * Desc:检测属性是否需要解密
 * @author l2h
 */
public class EncryptPropertyChecker {
    /**
     * 前缀
     */
    private String prefix = "SIMOS_ENC(";
    /**
     * 后缀
     */
    private String suffix = ")";
    public EncryptPropertyChecker(String prefix, String suffix){
        Assert.hasText(prefix,"prefix不能为空");
        Assert.hasText(suffix,"suffix不能为空");
        this.prefix = prefix;
        this.suffix =suffix;
    }
    public boolean isEcryptInfo(String value){

        if (StringUtils.isEmpty(value)){
            return false;
        }

        return value.trim().startsWith(prefix)&&value.trim().endsWith(suffix);
    }
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public EncryptPropertyChecker(){}
    public String removePrefixSuffix(String source){
        return source.substring(prefix.length(),(source.length()-suffix.length()));
    }
}
