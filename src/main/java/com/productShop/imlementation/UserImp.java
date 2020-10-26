package com.productShop.imlementation;

import com.productShop.imlementation.Interface_Imp.UserInt;
import com.productShop.models.User;
import com.productShop.builders.UserBuilder;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserImp implements UserInt {


    @Override
    public boolean add(User user) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "5340654");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = "INSERT INTO userconsumer (login, password) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        Connection connection = getConnection();
        try {
            String sql = "DELETE FROM userconsumer WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Math.toIntExact(user.getUserID()));
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    @Override
    public List<User> list() {
        List<User> list = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "SELECT DISTINCT * from user";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new UserBuilder()
                        .setUserID(resultSet.getInt("userID"))
                        .setLogin(resultSet.getString("login"))
                        .setPassword(resultSet.getString("password"))
                        .build();
                list.add(user);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public User getUser(String login) {
        Connection connection = getConnection();
        try {
            String sql = "SELECT * FROM userConsumer WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return new UserBuilder()
                    .setUserID(rs.getInt("userID"))
                    .setLogin(rs.getString("login"))
                    .setPassword(rs.getString("password"))
                    .build();
        } catch (SQLException e) {
            return null;
        }
    }
}