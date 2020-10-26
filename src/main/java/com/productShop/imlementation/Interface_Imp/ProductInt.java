package com.productShop.imlementation.Interface_Imp;

import com.productShop.models.Product;

import java.util.List;

public interface ProductInt extends Interface<Product> {
    List<Product> listProducts();
}