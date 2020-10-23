package com.productShop.builders;

import com.productShop.productsModel.Glaze;
import com.productShop.productsModel.Product;

import java.math.BigDecimal;

public class GlazeBuilder implements Builder {
    private Glaze glaze;

    public GlazeBuilder(Glaze glaze) {
        this.glaze = glaze;
    }

    @Override
    public void setProducingCountry(String country) {
        glaze.setProducing_country(country);
    }

    @Override
    public void setPrice(int price) {
        glaze.setPrice(price);
    }

    @Override
    public Product build() {
        return glaze;
    }

    public String setColor(String color) {
        return color;
    }
}
