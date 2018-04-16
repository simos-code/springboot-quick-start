package com.simos.entity;

/**
 * Created by l2h on 18-4-16.
 * Desc:用户实体类．这里只是个演示demo，所以只两个属性
 * @author l2h
 */
public class User {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
