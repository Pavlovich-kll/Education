package com.productShop.command;

import com.productShop.MainWork;

public class CommandList extends CommandAbstract {

    public CommandList(MainWork mainWork) {
        super(mainWork);
    }

    @Override
    public void execute() {
        mainWork.listOfProducts();
    }
}