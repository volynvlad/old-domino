package com.qqq.store;

import com.qqq.entity.Room;
import com.qqq.exception.StorageException;

import java.util.ArrayList;
import java.util.List;


public class RoomStorage {

    private static final RoomStorage INSTANCE = new RoomStorage();
    private List<Room> rooms;

    private RoomStorage() {
        this.rooms = new ArrayList<>();
    }

    public static RoomStorage getInstance() {
        return INSTANCE;
    }

    public void addRoom (Room room) {
        rooms.add(room);
    }

    public void removeRoom (Room room) throws StorageException {
        if (!isEmpty()) {
            rooms.remove(room);
        } else {
            throw new StorageException("There is no rooms in the storage");
        }
    }

    public void romoveRoomById (long id) throws StorageException {
        boolean flag = true;
        if (!isEmpty()) {
            for (Room room : rooms) {
                if (room.getRoomId() == id) {
                    rooms.remove(room);
                    flag = false;
                }
            }
            if (flag) {
                throw new StorageException("There is no room with " + id + " id");
            }
        } else {
            throw new StorageException("There is no rooms in the storage");
        }
    }

    public Room getRoomById(long id) throws StorageException {
        for (Room room : rooms) {
            if (room.getRoomId() == id) {
                return room;
            }
        }
        throw new StorageException("There is no room with " + id + " id");
    }

    public Room getRoomByName(String name) throws StorageException {
        for (Room room : rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        throw new StorageException("There is no room with " + name + " name");
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getNumberOfRooms() {
        return rooms.size();
    }

    public boolean isEmpty() {
        return rooms.isEmpty();
    }

}
