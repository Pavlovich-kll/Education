package com.productShop.realization;

import com.productShop.builders.BasketBuilder;
import com.productShop.imlementation.Interface_Imp.Interface;
import com.productShop.imlementation.ProductImp;
import com.productShop.models.Basket;
import com.productShop.models.Product;
import com.productShop.util.ScannerConnection;

import java.util.List;
import java.util.Scanner;

public class RShop {
    private final RUser rUser;
    private final RBasket rBasket = new RBasket();
    Scanner scanner = ScannerConnection.getScanner();

    public RShop(RUser rUser) {
        this.rUser = rUser;
    }

    public void start() {
        try {
            while (true) {
                System.out.println("Выберите действие:\n0)Выйти\n1)Добавить продукт\n2)Удалить продукт\n3)Список добавленных продуктов");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        deleteProduct();
                        break;
                    case 3:
                        listProducts();
                        break;
                    default:
                        System.out.println("Ошибка ввода команды, повторите действие");
                }
            }
        } catch (Exception e) {
            System.out.println("Команда отсутствует ");
        }
    }

    private void addProduct() {
        try {
            RBasket rBasket = new RBasket();
            Interface<Product> productImp = new ProductImp();
//            ProductBuilder productBuilder = new ProductBuilder();
            BasketBuilder basketBuilder = new BasketBuilder()
                    .setUser(rUser.getUser().getUserID());
            System.out.println("Список товаров\n---------------------------");
            productImp.list().forEach(v ->
                    System.out.printf("Номер %d\nНазвание:  %s\nТип: %s\nЦена за шт: %s ",
                            v.getProductID(), v.getName(), v.getType(), v.getPrice()
                                    + " руб\n---------------------------\n"));
//            rBasket.getListProducts().forEach(v ->
//                    System.out.printf("Номер %d\nНазвание:  %s\nТип: %s\nЦена за шт: %s ",
//                            v.getProductID(), v.getName(), v.getType(), v.getPrice()
//                                    + " руб\n---------------------------\n"));
            System.out.println("Введите номер продукта\n 0)Отмена");
            String sc = scanner.next();
            if (sc == null) return;
            else basketBuilder.setProduct(sc);
            System.out.println("Введите количество продукта\n 0)Отмена");
            int sc2 = scanner.nextInt();
            if (sc2 == 0) return;
            else basketBuilder.setCount(sc2);
            System.out.println("1)Оформить заказ\n0)Отмена");
            int sc3 = scanner.nextInt();
            if (sc3 == 0) return;

            if (rBasket.addProduct(basketBuilder.build())) System.out.println("Заказ успешно оформлен");
            else System.out.println("Заказ не оформлен");
        } catch (Exception e) {
            System.out.println("команда введена неверно: " + e.getMessage());
        }
    }

    private void deleteProduct() {
        System.out.println("Введите название продукта");
//        Product product = new ProductBuilder()
        Basket basket = new BasketBuilder()
//                .setUser(rUser.getUser().getUserID())
                .setProduct(scanner.next())
                .build();
        if (rBasket.deleteProduct(basket)) System.out.println("Продукт удалён");
        else System.out.println("Ошибка в имени продукта");
    }

    private void listProducts() {
        List<Basket> orderList = rBasket.getListProducts();
        if (orderList.size() == 0) {
            System.out.println("Корзина пуста\n");
            return;
        }
        System.out.println("Список добавленных продуктов:\n---------------------------");
        orderList.forEach(v ->
                System.out.printf("UserID %d\nНазвание: %s\nКол-во: \n",
                        v.getUser(), v.getProduct(), v.getCount()));
    }
}