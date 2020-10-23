package com.productShop.builders;

import com.productShop.productsModel.Product;

import java.math.BigDecimal;

public interface Builder {
    public void setProducingCountry(String country);
    public void setPrice(int price);
    public Product build();
}
