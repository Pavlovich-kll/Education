package com.productShop.models;

import java.util.Objects;

public class User {
    private Integer userID;
    private String login;
    private String password;

    public User() {
    }

    public User(Integer userID, String login, String password) {
        this.userID = userID;
        this.login = login;
        this.password = password;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID( Integer userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID.equals(user.userID) &&
                login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, login, password);
    }
}