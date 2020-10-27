package com.productShop.models;

import java.util.Objects;

public class ProductList {
    private Integer productID;
    private String name;
    private String type;
    private Integer price;
    private Integer count;

    public ProductList() {
    }

    public ProductList(Integer productID, String name, String type, Integer price, Integer count) {
        this.productID = productID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.count = count;
    }

    public ProductList(Integer productID, String name, String type, Integer price) {
        this.productID = productID;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        ProductList that = (ProductList) o;
        return productID.equals(that.productID) &&
                name.equals(that.name) &&
                type.equals(that.type) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, type, price);
    }
}