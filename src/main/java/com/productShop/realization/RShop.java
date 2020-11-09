package com.productShop.realization;

import com.productShop.builders.BasketBuilder;
import com.productShop.models.Basket;
import com.productShop.models.BasketList;
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
                        addProductInBasket();
                        break;
                    case 2:
                        deleteBasket();
                        break;
                    case 3:
                        listBaskets();
                        break;
                    default:
                        System.out.println("Ошибка ввода команды, повторите действие");
                }
            }
        } catch (Exception e) {
            System.out.println("Команда отсутствует ");
        }
    }

    private void addProductInBasket() {
        try {
            RBasket rBasket = new RBasket();
            BasketBuilder basketBuilder = new BasketBuilder()
                    .setUser(rUser.getUser().getUserID());
            System.out.println("Список товаров\n---------------------------");
            rBasket.getListProducts().forEach(v ->
                    System.out.printf("Номер %d\nНазвание:  %s\nТип: %s\nЦена за шт: %s ",
                            v.getProductID(), v.getName(), v.getType(), v.getPrice()
                                    + " руб\n---------------------------\n"));
            System.out.println("Введите название продукта\n 0)Отмена");
            int sc = scanner.nextInt();
            if (sc == 0) return;
            else basketBuilder.setProduct(sc);
            System.out.println("Введите количество продукта\n 0)Отмена");
            sc = scanner.nextInt();
            if (sc == 0) return;
            else basketBuilder.setCount(sc);
            System.out.println("1)Оформить заказ\n0)Отмена");
            sc = scanner.nextInt();
            if (sc == 0) return;
            if (rBasket.addProductBasket(basketBuilder.build())) System.out.println("Заказ успешно оформлен");
            else System.out.println("Заказ не оформлен");
        } catch (Exception e) {
            System.out.println("команда введена неверно: " + e.getMessage());
        }
    }

    private void deleteBasket() {
        System.out.println("Введите номер корзины");
        Basket basket = new BasketBuilder()
                .setUser(rUser.getUser().getUserID())
                .setBasketID(scanner.nextInt())
                .build();
        if (rBasket.deleteProductBasket(basket)) System.out.println("Продукт удалён");
        else System.out.println("Ошибка ввода корзины");
    }

    private void listBaskets() {
        List<BasketList> orderList = rBasket.getUserBasketList(rUser.getUser());;
        if (orderList.size() == 0) {
            System.out.println("Корзина пуста\n");
            return;
        }
        System.out.println("Список добавленных продуктов:\n---------------------------");
        orderList.forEach(v ->
                System.out.printf("Номер %d\nНазвание: %s\nТип: %s\nЦена: %s\nКол-во: %d\n",
                        v.getBasketID(), v.getProduct(), v.getTypeName(), v.getPrice(), v.getCount()));
    }
}