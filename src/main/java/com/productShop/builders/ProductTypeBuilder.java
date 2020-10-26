package com.productShop.builders;

import com.productShop.models.ProductType;

public class ProductTypeBuilder {
    private Long productTypeID;
    private String typeName;

    public ProductTypeBuilder setProductTypeID(Long productTypeID) {
        this.productTypeID = productTypeID;
        return this;
    }

    public ProductTypeBuilder setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public ProductType build() {
        return new ProductType();
    }
}