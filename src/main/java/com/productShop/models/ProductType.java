package com.productShop.models;

import java.util.Objects;

public class ProductType {
    private Long productTypeID;
    private String typeName;

    public ProductType() {
    }

    public ProductType(Long productTypeID, String typeName) {
        this.productTypeID = productTypeID;
        this.typeName = typeName;
    }

    public Long getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(Long productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return productTypeID.equals(that.productTypeID) &&
                typeName.equals(that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeID, typeName);
    }
}