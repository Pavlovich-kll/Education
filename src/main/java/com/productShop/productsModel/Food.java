package com.productShop.productsModel;

public class Food extends Product {
    private Integer sizeOfPortion;
    private String type = "food";

    public Integer getSizeOfPortion() {
        return sizeOfPortion;
    }

    public void setSizeOfPortion(Integer sizeOfPortion) {
        this.sizeOfPortion = sizeOfPortion;
    }

    public String getType() {
        return type;
    }

}