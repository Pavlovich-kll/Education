package com.productShop.command;

import com.productShop.MainWork;

public class CommandDelete extends CommandAbstract {

    public CommandDelete(MainWork mainWork) {
        super(mainWork);
    }

    @Override
    public void execute() {
        mainWork.delete();
    }
}