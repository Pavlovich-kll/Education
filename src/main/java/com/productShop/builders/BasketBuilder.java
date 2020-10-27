package com.productShop.builders;

import com.productShop.models.Basket;

public class BasketBuilder {
    private Integer basketID;
    private Integer user;
    private Integer productID;
    private Integer count;

    public BasketBuilder setBasketID(Integer basketID) {
        this.basketID = basketID;
        return this;
    }

    public BasketBuilder setUser(Integer user) {
        this.user = user;
        return this;
    }

    public BasketBuilder setProduct(Integer productID) {
        this.productID = productID;
        return this;
    }

    public BasketBuilder setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Basket build() {
        return new Basket(basketID,user,productID,count);
    }
}