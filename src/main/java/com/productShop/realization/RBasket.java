package com.productShop.realization;

import com.productShop.imlementation.BasketImp;
import com.productShop.imlementation.Interface_Imp.BasketInt;
import com.productShop.imlementation.Interface_Imp.Interface;
import com.productShop.imlementation.ProductImp;
import com.productShop.models.Basket;
import com.productShop.models.Product;

import java.util.List;

/**
 * Реализация логики корзины:
 * добавление, удаление продуктов и вывод их списка
 */

public class RBasket {
//    Interface<Product> productInt = new ProductImp();
    BasketInt basketInt = new BasketImp();

    public boolean addProduct(Basket basket) {
        return basketInt.add(basket);
    }

    public boolean deleteProduct(Basket basket) {
        return basketInt.delete(basket);
    }

    public List<Basket> getListProducts() {
        return basketInt.list();
    }
}
