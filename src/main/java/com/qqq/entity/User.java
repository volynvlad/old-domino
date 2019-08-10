package com.qqq.entity;

import com.qqq.create.RoomCreator;
import com.qqq.store.RoomStorage;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static AtomicInteger nextId = new AtomicInteger();
    private long userId;
    private String login;
    private String password;

    {
        userId = nextId.incrementAndGet();
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(long userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void createRoom() {
        RoomStorage roomStorage = RoomStorage.getInstance();
        roomStorage.addRoom(RoomCreator.create());
    }

    public void createRoom(String name) {
        RoomStorage roomStorage = RoomStorage.getInstance();
        roomStorage.addRoom(RoomCreator.create(name));
    }
}
