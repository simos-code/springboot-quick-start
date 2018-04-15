package com.simos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l2h on 18-4-15.
 * Desc:　配置文件信息
 * @author l2h
 */
@ConfigurationProperties(prefix = "simos")
public class SimosProperties {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 体重
     */
    private Double bodyWeight;
    /**
     * 年龄
     */
    private int age;
    /**
     * 女票
     */
    private  GirlFriend girlFriend = new GirlFriend();
    /**
     * 基友
     */
    private List<Friend> friends = new ArrayList<>();
    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Double getBodyWeight() {
        return bodyWeight;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBodyWeight(Double bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GirlFriend getGirlFriend(){
        return this.girlFriend;
    }
    public List<Friend> getFriends(){
        return this.friends;
    }
}
