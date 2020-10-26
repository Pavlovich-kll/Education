package com.productShop.imlementation;

import com.productShop.builders.ProductBuilder;
import com.productShop.imlementation.Interface_Imp.Interface;
import com.productShop.models.Product;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductImp implements Interface<Product> {

    @Override
    public boolean add(Product product) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO product (name, type, price) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getType());
            preparedStatement.setInt(3, product.getPrice());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Product product) {
        Connection connection = getConnection();
        try {
            String sql = "DELETE FROM product WHERE productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getProductID());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> list() {
        List<Product> list = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "SELECT DISTINCT * FROM product";
            ResultSet ps = statement.executeQuery(sql);
            while (ps.next()) {
                Product product = new ProductBuilder()
                        .setProductID(ps.getInt("productID"))
                        .setName(ps.getString("name"))
                        .setType(ps.getInt("type"))
                        .setPrice(ps.getInt("price"))
                        .build();
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}