package com.productShop.command;

import com.productShop.MainWork;

public class CommandAdd extends CommandAbstract {

    public CommandAdd(MainWork mainWork) {
        super(mainWork);
    }

    @Override
    public void execute() {
        mainWork.add();
    }
}