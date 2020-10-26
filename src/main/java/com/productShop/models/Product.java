package com.productShop.models;

import java.util.Objects;

public class Product {
    private Integer productID;
    private String name;
    private Integer type;
    private Integer price;

    public Product() {
    }

    public Product(Integer productID, String name, Integer type, Integer price) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID.equals(product.productID) &&
                name.equals(product.name) &&
                type.equals(product.type) &&
                price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, type, price);
    }
}