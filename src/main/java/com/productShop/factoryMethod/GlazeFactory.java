package com.productShop.factoryMethod;

import com.productShop.productsModel.Glaze;
import com.productShop.productsModel.Product;

public class GlazeFactory extends AbstractFactory {
    @Override
    public Product createProduct() {
        return new Glaze();
    }
}