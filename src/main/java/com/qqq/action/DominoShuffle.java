package com.qqq.action;

import com.qqq.entity.Domino;
import com.qqq.entity.Room;


import java.util.ArrayList;
import java.util.Collections;


public class DominoShuffle {

    public static void shuffle(Room.DominoBank dominoBank) {

        ArrayList<Domino> bankDomino = dominoBank.getDominos();
        Collections.shuffle(bankDomino);
        dominoBank.setDominos(bankDomino);
    }
}
