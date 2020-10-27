package com.productShop.realization;

import com.productShop.imlementation.BasketImp;
import com.productShop.imlementation.Interface_Imp.BasketInt;
import com.productShop.imlementation.Interface_Imp.ProductInt;
import com.productShop.imlementation.ProductImp;
import com.productShop.models.Basket;
import com.productShop.models.BasketList;
import com.productShop.models.ProductList;
import com.productShop.models.User;

import java.util.List;

/**
 * Реализация логики корзины:
 * добавление, удаление продуктов и вывод их списка
 */

public class RBasket {
    ProductInt productInt = new ProductImp();
    BasketInt basketInt = new BasketImp();

    public boolean addProductBasket(Basket basket) {
        return basketInt.add(basket);
    }

    public boolean deleteProductBasket(Basket basket) {
        return basketInt.delete(basket);
    }

    public List<ProductList> getListProducts() {//вывод списка товаров
        return productInt.listProducts();
    }

    public List<BasketList> getUserBasketList(User user) {//вывод списка заказов пользователя
        return basketInt.getBasketList(user);
    }
}