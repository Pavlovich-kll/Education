package com.productShop.builders;

import com.productShop.models.Product;

public class ProductBuilder {
    private Integer productID;
    private String name;
    private Integer type;
    private Integer price;

    public ProductBuilder setProductID(Integer productID) {
        this.productID = productID;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setType(Integer type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(productID, name, type, price);
    }
}