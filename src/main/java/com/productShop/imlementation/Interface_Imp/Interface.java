package com.productShop.imlementation.Interface_Imp;

import com.productShop.util.DBConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface Interface<T> {
    default Connection getConnection() {
        return DBConnection.getConnection();
    }

    boolean add(T t);

    boolean delete(T t);

    List<T> list();
}