package com.productShop.imlementation.Interface_Imp;

import com.productShop.models.Basket;
import com.productShop.models.BasketList;
import com.productShop.models.User;

import java.util.List;

public interface BasketInt extends Interface<Basket> {
    public List<BasketList> getBasketList(User user);
}