package com.productShop.imlementation;

import com.productShop.builders.BasketBuilder;
import com.productShop.builders.BasketListBuilder;
import com.productShop.imlementation.Interface_Imp.BasketInt;
import com.productShop.models.Basket;
import com.productShop.models.BasketList;
import com.productShop.models.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BasketImp implements BasketInt {

    @Override
    public boolean add(Basket basket) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO basket(userID,productID,count) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, basket.getUser());
            preparedStatement.setInt(2, basket.getProductID());
            preparedStatement.setInt(3, basket.getCount());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Basket basket) {
        Connection connection = getConnection();
        try {
            String sql = "delete from basket where basketid = ? and userID = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, basket.getBasketID());
            preparedStatement.setString(2, basket.getUser().toString());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Basket> list() {
        List<Basket> list = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from basket order by basketID";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Basket basket = new BasketBuilder()
                        .setBasketID(resultSet.getInt("userID"))
                        .setBasketID(resultSet.getInt("productID"))
                        .setBasketID(resultSet.getInt("count"))
                        .build();
                list.add(basket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BasketList> getBasketList(User user) {
        List<BasketList> res = new LinkedList<>();
        try {
            String sql = "select distinct * from basketlist where userID = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUserID().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BasketList basketList = new BasketListBuilder()
                        .setBasketID(resultSet.getInt("basketID"))
                        .setProduct(resultSet.getString("nameProduct"))
                        .setTypeName(resultSet.getString("typeName"))
                        .setPrice(resultSet.getInt("price"))
                        .setCount(resultSet.getInt("count"))
                        .build();
                res.add(basketList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}