package com.qqq.create;

import com.qqq.entity.User;

public class UserCreator {
    public User create(String login, String password) {
        return new User(login, password);
    }
}
