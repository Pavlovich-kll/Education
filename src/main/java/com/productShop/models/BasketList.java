package com.productShop.models;

import java.util.Objects;

public class BasketList {

    private Integer basketID;
    private String product;
    private String typeName;
    private Integer price;
    private Integer count;

    public BasketList() {
    }

    public BasketList(Integer basketID, String product, String typeName, Integer price, Integer count) {
        this.basketID = basketID;
        this.product = product;
        this.typeName = typeName;
        this.price = price;
        this.count = count;
    }

    public Integer getBasketID() {
        return basketID;
    }

    public void setBasketID(Integer basketID) {
        this.basketID = basketID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        BasketList that = (BasketList) o;
        return basketID.equals(that.basketID) &&
                product.equals(that.product) &&
                typeName.equals(that.typeName) &&
                price.equals(that.price) &&
                count.equals(that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketID, product, typeName, price, count);
    }
}