package com.productShop.builders;

import com.productShop.models.Basket;

public class BasketBuilder {
    private Integer basketID;
    private Integer user;
    private String  product;
    private Integer count;

    public BasketBuilder setBasketID(Integer basketID) {
        this.basketID = basketID;
        return this;
    }

    public BasketBuilder setUser(Integer user) {
        this.user = user;
        return this;
    }

    public BasketBuilder setProduct(String product) {
        this.product = product;
        return this;
    }

    public BasketBuilder setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Basket build() {
        return new Basket(basketID,user,product,count);
    }
}