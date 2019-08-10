package com.qqq;

import com.qqq.create.RoomCreator;
import com.qqq.entity.Player;
import com.qqq.entity.Room;
import com.qqq.exception.IncorrectValueException;
import com.qqq.exception.StorageException;
import com.qqq.game.Game;
import com.qqq.store.RoomStorage;

public class Management {
    public static void main(String[] args) throws StorageException, IncorrectValueException {
        RoomStorage roomStorage = RoomStorage.getInstance();
        roomStorage.addRoom(RoomCreator.create("AFS"));
        Room room = roomStorage.getRooms().get(0);
        room.createAndShuffleBank();
        room.addPlayer(new Player("pasha","123"));
        room.addPlayer(new Player("zhenya","123"));
        room.addPlayer(new Player("vlad","123"));
        Game game1 = new Game();
        game1.game(room);
    }
}
