package com.qqq.create;

import com.qqq.entity.Room;

public class RoomCreator {

    public static Room create() {
        return new Room();
    }

    public static Room create(String name) {
        return new Room(name);
    }
}
