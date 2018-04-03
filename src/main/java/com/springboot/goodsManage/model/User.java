package com.springboot.goodsManage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    // 用户名
    private String username;
    // 手机号码
    private String mobile;
    // 公司名称
    private String company;
    // 身份证
    private String id_card;
    // 密码
    private String password;
    // 用户类型 1:货主，2:司机
    private int type;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
