package com.productShop.imlementation.Interface_Imp;

import com.productShop.models.User;

public interface UserInt extends Interface<User> {
    User getUser(String login);
}