package com.productShop.realization;

import com.productShop.builders.UserBuilder;
import com.productShop.imlementation.BasketImp;
import com.productShop.imlementation.Interface_Imp.BasketInt;
import com.productShop.imlementation.Interface_Imp.UserInt;
import com.productShop.imlementation.UserImp;
import com.productShop.models.User;

/**
 * логика работы авторизации и регистрации пользователя
 */

public class RUser {
    private final UserInt userInt = new UserImp();
    private final BasketInt basketInt = new BasketImp();
    private User user;

    public User getUser() {
        return user;
    }

    public boolean authorization(User userExpected) {
        try {
            userExpected = userInt.getUser(userExpected.getLogin());
//            if (userExpected != null && userExpected.getPassword().equals(user.getPassword())) {
            if (userExpected != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registration(User user) {
        try {
            return userInt.add(new UserBuilder()
                    .setLogin(user.getLogin())
                    .setPassword(user.getPassword())
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}