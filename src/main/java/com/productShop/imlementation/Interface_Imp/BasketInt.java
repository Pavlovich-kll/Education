package com.productShop.imlementation.Interface_Imp;

import com.productShop.models.Basket;
import com.productShop.models.User;

public interface BasketInt extends Interface<Basket> {
    public Basket getUserBasket(User user);
}