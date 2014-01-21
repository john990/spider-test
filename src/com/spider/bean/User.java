package com.spider.bean;

/**
 * Created by kai.wang on 1/7/14.
 */
public class User {
    private String id = "";
    private String name = "";
    private String password = "";
    private String avatar = "";
    private String email = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name:" + name + ",password:" + password + ",email:" + email + ",avatar:" + avatar;
    }
}
