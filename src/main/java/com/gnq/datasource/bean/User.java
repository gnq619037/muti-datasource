package com.gnq.datasource.bean;

import java.io.Serializable;

/**
 * user类,对应t_user表
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3636019088819975261L;
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
