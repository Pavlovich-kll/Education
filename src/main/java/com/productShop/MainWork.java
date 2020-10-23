package com.productShop;

import com.productShop.basket.BasketProducts;
import com.productShop.builders.FoodBuilder;
import com.productShop.builders.GlazeBuilder;
import com.productShop.factoryMethod.AbstractFactory;
import com.productShop.factoryMethod.FoodFactory;
import com.productShop.factoryMethod.GlazeFactory;
import com.productShop.productsModel.Food;
import com.productShop.productsModel.Glaze;
import com.productShop.productsModel.Product;

import java.math.BigDecimal;

public class MainWork {
    private static Product product;

    public void add() {
        //Добавляем Еду в список:
        //-------------------------------
        AbstractFactory abstractFactory;
        abstractFactory = new FoodFactory();
        FoodBuilder fBuilder = new FoodBuilder((Food) abstractFactory.createProduct());
        fBuilder.setProducingCountry("France");
        fBuilder.setSizeOfPortion(2);
        fBuilder.setPrice(1250);
        //получаем наш продукт
        product = fBuilder.build();
        //в качестве ключа:страна + цена
        BasketProducts.getProductList().put(product.getProducing_country() + product.getPrice(), product);

        //Добавляем Глазурь в список:
        //-------------------------------
        abstractFactory = new GlazeFactory();
        GlazeBuilder gBuilder = new GlazeBuilder((Glaze) abstractFactory.createProduct());
        gBuilder.setProducingCountry("Germany");
        gBuilder.setColor("blue");
        gBuilder.setPrice(500);
        product = gBuilder.build();
        BasketProducts.getProductList().put(product.getProducing_country() + product.getPrice(), product);
    }

    public void delete() {
        String productCountry = "France";
        int price = 1250;
        BasketProducts.getProductList().remove(productCountry.concat(String.valueOf(price)));
    }

    public void listOfProducts() {
        //https://vertex-academy.com/tutorials/ru/java-8-foreach/
        BasketProducts.getProductList().forEach((k, v) -> {
            System.out.printf("Country: %s\nPrice: %s\nType: %s", v.getProducing_country(), v.getPrice() + " rub.", v.getType());
        });
    }

    public static void main(String[] args) {
        MainWork mainWork = new MainWork();
        mainWork.add();
        mainWork.delete();
        mainWork.listOfProducts();
    }
}