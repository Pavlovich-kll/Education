package com.productShop.models;

import java.util.Objects;

public class Basket {

    private Integer basketID;
    private Integer user;
    private Integer product;
    private Integer count;

    public Basket() {
    }

    public Basket(Integer basketID, Integer user, Integer product, Integer count) {
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

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
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
        Basket basket = (Basket) o;
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