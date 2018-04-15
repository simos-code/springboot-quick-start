package com.simos.config;

/**
 * Created by l2h on 18-4-15.
 * Desc: 朋友
 *
 * @author l2h
 */

public class Friend {
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


}
