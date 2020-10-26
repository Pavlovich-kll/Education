package com.productShop.imlementation;

import com.productShop.builders.ProductTypeBuilder;
import com.productShop.imlementation.Interface_Imp.Interface;
import com.productShop.models.ProductType;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductTypeImp implements Interface<ProductType> {

    @Override
    public boolean add(ProductType productType) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO productType (typeName) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productType.getTypeName());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(ProductType productType) {
        Connection connection = getConnection();
        try {
            String sql = "DELETE FROM productType WHERE productTypeID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(productType.getProductTypeID()));
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ProductType> list() {
        List<ProductType> list = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "SELECT DISTINCT * FROM producttype ORDER BY productTypeID";
            ResultSet pts = statement.executeQuery(sql);
            while (pts.next()) {
                ProductType productType = new ProductTypeBuilder()
                        .setProductTypeID((long) pts.getInt("productTypeID"))
                        .setTypeName(pts.getString("typeName"))
                        .build();
                list.add(productType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}