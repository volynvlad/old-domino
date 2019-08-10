package com.qqq.create;

import com.qqq.entity.Player;

public class PlayerCreator extends UserCreator {
    public Player create(String login, String password) {
        return new Player(login, password);
    }
}
