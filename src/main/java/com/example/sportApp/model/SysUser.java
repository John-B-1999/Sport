package com.example.sportApp.model;

import io.swagger.annotations.ApiModel;

/**
 * @author ywm
 */
@ApiModel
public class SysUser {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
