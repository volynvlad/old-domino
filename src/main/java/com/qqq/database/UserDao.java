package com.qqq.database;

import com.qqq.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao extends Dao {
    private static final String USER_ID = "USER_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_PASSWORD = "USER_PASSWORD";
    private static final String ALL_FIELDS = "USER_ID, USER_NAME, USER_PASSWORD";
    private static final String USER_TABLE = "user";

    private static Connection connection;

    public UserDao() throws SQLException, ClassNotFoundException {
        connection = getConnection();
        System.out.println("Connected to database...");
    }

    public ArrayList<User> selectAll() throws SQLException {

        Statement statement = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT " +
                    ALL_FIELDS + " FROM " + USER_TABLE);
            while (rs.next()) {
                int userId = rs.getInt(USER_ID);
                String userName = rs.getString(USER_NAME);
                String userPassword = rs.getString(USER_PASSWORD);
                users.add(new User(userId, userName, userPassword));
                //System.out.println(userId + "\t" + userName + "\t" + userPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return users;
    }

    public void insert(User user) throws SQLException {

        final String SQL = "insert into " + USER_TABLE + " values" +
                '(' + user.getUserId() + ",'" +
                user.getLogin() + "','" + user.getPassword() + "');";

        Statement statement = connection.createStatement();

        statement.execute(SQL);

        statement.close();
    }

}
