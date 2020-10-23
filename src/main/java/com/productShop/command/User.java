package com.productShop.command;

public class User {
    CommandInterface add;
    CommandInterface del;
    CommandInterface list;

    public User(CommandInterface add, CommandInterface del, CommandInterface list) {
        this.add = add;
        this.del = del;
        this.list = list;
    }

    public void addProduct() {
        add.execute();
    }

    public void delProduct() {
        del.execute();
    }

    public void listProduct() {
        list.execute();
    }
}