package com.productShop.builders;

import com.productShop.models.BasketList;

public class BasketListBuilder {
    private Integer basketID;
    private Integer userID;
    private String product;
    private String typeName;
    private Integer price;
    private Integer count;

    public BasketListBuilder setBasketID(Integer basketID) {
        this.basketID = basketID;
        return this;
    }

    public BasketListBuilder setProduct(String product) {
        this.product = product;
        return this;
    }

    public BasketListBuilder setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public BasketListBuilder setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public BasketListBuilder setCount(Integer count) {
        this.count = count;
        return this;
    }

    public BasketList build() {
        return new BasketList(basketID, product, typeName, price, count);
    }
}