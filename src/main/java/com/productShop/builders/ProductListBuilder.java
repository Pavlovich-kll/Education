package com.productShop.builders;

import com.productShop.models.ProductList;

public class ProductListBuilder {
    private Integer productID;
    private String name;
    private String type;
    private Integer price;

    public ProductListBuilder setProductID(Integer productID) {
        this.productID = productID;
        return this;
    }

    public ProductListBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductListBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ProductListBuilder setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ProductList build() {
        return new ProductList(productID, name, type, price);
    }
}