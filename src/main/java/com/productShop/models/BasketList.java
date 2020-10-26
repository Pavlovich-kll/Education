package com.productShop.models;

import java.util.Objects;

public class BasketList {

    private Integer basketID;
    private Integer user;
    private String product;
    private Integer count;

    public BasketList() {
    }

    public BasketList(Integer basketID, Integer user, String product, Integer count) {
        this.basketID = basketID;
        this.user = user;
        this.product = product;
        this.count = count;
    }

    public Integer getBasketID() {
        return basketID;
    }

    public void setBasketID(Integer basketID) {
        this.basketID = basketID;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketList basket = (BasketList) o;
        return basketID.equals(basket.basketID) &&
                user.equals(basket.user) &&
                product.equals(basket.product) &&
                count.equals(basket.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketID, user, product, count);
    }
}