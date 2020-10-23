package com.productShop.factoryMethod;

import com.productShop.productsModel.Food;
import com.productShop.productsModel.Product;

public class FoodFactory extends AbstractFactory {
    @Override
    public Product createProduct() {
        return new Food();
    }
}