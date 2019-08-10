package com.qqq;

import com.qqq.database.UserDao;
import com.qqq.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class DB_Management {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();
        User zhenya = new User(100,"zhenya", "123");

        System.out.println("......");
        ArrayList<User> users = userDao.selectAll();
        for (User user : users) {
            System.out.println(user.getUserId() + ":" + user.getLogin() + " - " + user.getPassword());
        }

        System.out.println("......");
        userDao.insert(zhenya);
        users = userDao.selectAll();
        for (User user : users) {
            System.out.println(user.getUserId() + ":" + user.getLogin() + " - " + user.getPassword());
        }

    }
}
