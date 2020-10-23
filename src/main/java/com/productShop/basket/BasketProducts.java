package com.productShop.basket;

import com.productShop.productsModel.Product;

import java.util.HashMap;

public class BasketProducts {

    private static HashMap<String, Product> productList;

    public BasketProducts() {
    }

    public static HashMap<String, Product> getProductList() {
        if (productList == null) {
            productList = new HashMap<>();
        }
        return productList;
    }

    public static void setProductList(HashMap<String, Product> productList) {
        BasketProducts.productList = productList;
    }
}