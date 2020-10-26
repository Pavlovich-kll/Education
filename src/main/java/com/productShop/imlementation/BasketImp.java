package com.productShop.imlementation;

import com.productShop.builders.BasketBuilder;
import com.productShop.imlementation.Interface_Imp.BasketInt;
import com.productShop.models.Basket;
import com.productShop.models.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BasketImp implements BasketInt {
    @Override
    public Basket getUserBasket(User user) {
        return null;
    }

    @Override
    public boolean add(Basket basket) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO basket(userID,product,count) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, basket.getUser());
            preparedStatement.setString(2, basket.getProduct());
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
            String sql = "delete from basket where product = ? and userID = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, basket.getProduct());
            preparedStatement.setInt(2, basket.getUser());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Basket> list() {
        List<Basket> list = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from basket order by basketID";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Basket basket = new BasketBuilder()
                        .setUser(resultSet.getInt("userID"))
                        .setProduct(resultSet.getString("product"))
                        .setCount(resultSet.getInt("count"))
                        .build();
                list.add(basket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}