package com.productShop.command;

import com.productShop.MainWork;

public abstract class CommandAbstract implements CommandInterface {
    protected MainWork mainWork;

    public CommandAbstract(MainWork mainWork) {
        this.mainWork = mainWork;
    }
}