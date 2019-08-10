package com.qqq.create;

import com.qqq.entity.Domino;

import java.util.ArrayList;

public class DominoCreator {

    /**
     *
     * @return List of Domino's
     */

    public static ArrayList<Domino> createList() {
        ArrayList<Domino> dominoArrayList = new ArrayList<>();
        for (int i = 0;i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominoArrayList.add(new Domino(i, j));
            }
        }
        return dominoArrayList;
    }
}
