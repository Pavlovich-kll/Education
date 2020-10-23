package com.productShop.productsModel;

import java.math.BigDecimal;

public abstract class Product {
private String producing_country;
private int price;

    public String getProducing_country() {
        return producing_country;
    }

    public void setProducing_country(String producing_country) {
        this.producing_country = producing_country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract String getType();

}