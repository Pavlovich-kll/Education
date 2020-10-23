package com.productShop.builders;

import com.productShop.productsModel.Food;
import com.productShop.productsModel.Product;

import java.math.BigDecimal;

public class FoodBuilder implements Builder {
    private Food food;

    public FoodBuilder(Food food) {
        this.food = food;
    }

    @Override
    public void setProducingCountry(String country) {
        food.setProducing_country(country);
    }

    @Override
    public void setPrice(int price) {
        food.setPrice(price);
    }

    @Override
    public Product build() {
        return food;
    }

    public Integer setSizeOfPortion(Integer sizeOfPortion) {
        return sizeOfPortion;
    }
}
