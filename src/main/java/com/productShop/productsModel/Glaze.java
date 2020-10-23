package com.productShop.productsModel;

public class Glaze extends Product {
private String color;
private String type = "glaze";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

}