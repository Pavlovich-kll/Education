package com.productShop.builders;

import com.productShop.models.User;

public class UserBuilder {
    private Integer userID;
    private String login;
    private String password;


    public UserBuilder setUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public UserBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(userID,login,password);
    }
}