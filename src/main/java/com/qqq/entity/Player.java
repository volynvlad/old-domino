package com.qqq.entity;

import com.qqq.exception.IncorrectValueException;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Player extends User {

    private static AtomicInteger nextId = new AtomicInteger();
    private long playerId;
    private ArrayList<Domino> hand;
    private int score;
    private boolean isMoving = false;

    {
        playerId = nextId.incrementAndGet();
        hand = new ArrayList<>();
        score = 0;
    }

    public Player(String login, String password) {
        super(login, password);
    }

    public long getPlayerId() {
        return playerId;
    }

    public ArrayList<Domino> getHand() {
        return hand;
    }

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public boolean hasAvailable() {
        for (Domino domino : hand) {
            if (domino.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score = this.score + score;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void changedMoving() {
        isMoving = !isMoving;
    }

    public void addDomino(Domino domino) {
        hand.add(domino);
    }

    public boolean hasDouble() {
        for (Domino domino : hand) {
            if (domino.isDouble()) {
                return true;
            }
        }
        return false;
    }

    public Domino maxDouble() {
        Domino result = null;
        for (Domino domino : hand) {
            if (domino.isDouble()) {
                if (result != null) {
                    if (result.getLeft() < domino.getLeft()) {
                        result = domino;
                    }
                } else {
                    result = domino;
                }
            }
        }
        return result;
    }

    public Domino maxDomino() {
        Domino result = hand.get(0);
        for (Domino domino : hand) {
            if (result.getSum() < domino.getSum()) {
                result = domino;
            }
        }
        return result;
    }

    public String handToString() {
        if (isHandEmpty()) {
            return "there is no domino in hand";
        } else {
            StringBuilder res = new StringBuilder("|" + getLogin() + "||");
            for (Domino domino : hand) {
                res.append(domino.toString());
                res.append("|");
            }
            return res.toString();
        }
    }

    public String availableHandToString() {
        if (isHandEmpty()) {
            return "there is no domino in hand";
        } else {
            StringBuilder res = new StringBuilder("|" + getLogin() + "||");
            for (Domino domino : hand) {
                if (domino.isAvailable()) {
                    res.append(domino.toString());
                    res.append("|");
                }
            }
            return res.toString();
        }
    }

    public void putOnEmpty(Room.Table table, int num) throws IncorrectValueException {
        if(hand.contains(hand.get(num))) {
            if (hand.get(num).isAvailable()) {
                if (table.isEmpty()) {
                    table.addFirstDomino(hand.get(num));
                    hand.remove(hand.get(num));
                }
            } else {
                throw new IncorrectValueException(hand.get(num).toString() + " is not available");
            }
        } else {
            throw new IncorrectValueException(hand.get(num).toString() + " is not in your hand");
        }
    }

    public void putOn(Room.Table table, int num, boolean isLeft) throws IncorrectValueException {
        if(hand.contains(hand.get(num))) {
            if (hand.get(num).isAvailable()) {
                if (!table.isEmpty()) {
                    if (isLeft) {
                        if (hand.get(num).getLeft() == table.getLeftSide()) {
                            hand.get(num).swap();
                        }
                        table.addToLeftEdge(hand.get(num));
                        hand.remove(hand.get(num));
                    }
                    if (!isLeft) {
                        if (hand.get(num).getRight() == table.getRightSide()) {
                            hand.get(num).swap();
                        }
                        table.addToRightEdge(hand.get(num));
                        hand.remove(hand.get(num));
                    }
                }
            } else {
                throw new IncorrectValueException(hand.get(num).toString() + " is not available");
            }
        } else {
            throw new IncorrectValueException(hand.get(num).toString() + " is not in your hand");
        }
    }

    public int getSum() {
        int sum = 0;
        for (Domino domino : hand) {
            sum = domino.getSum() + sum;
        }
        return sum;
    }

    public void clear() {
        hand.clear();
    }
}
