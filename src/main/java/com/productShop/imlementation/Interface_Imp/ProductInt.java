package com.productShop.imlementation.Interface_Imp;

import com.productShop.models.Product;
import com.productShop.models.ProductList;

import java.util.List;

public interface ProductInt extends Interface<Product> {
    List<ProductList> listProducts();
}