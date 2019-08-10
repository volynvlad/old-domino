package com.qqq.entity;

import com.qqq.create.DominoCreator;
import com.qqq.exception.IncorrectValueException;
import com.qqq.exception.StorageException;
import com.qqq.action.DominoShuffle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class Room {

    private static final int MAX_NUMBER_OF_PLAYERS = 4;

    private static AtomicInteger nextId = new AtomicInteger();

    private long roomId;
    private String name;
    private ArrayList<Player> players;
    private DominoBank dominoBank;
    private Table table;
    private boolean inGame;

    {
        roomId = nextId.incrementAndGet();
        dominoBank = new DominoBank();
        table = new Table();
        players = new ArrayList<>();
        inGame = false;
    }

    public Room() { }

    public Room(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getRoomId() {
        return roomId;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public DominoBank getDominoBank() {
        return dominoBank;
    }

    public Table getTable() {
        return table;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void changeInGameStatement() {
        inGame = !inGame;
    }

    public void addPlayer(Player player) throws StorageException {
        if (isAvailable()) {
            players.add(player);
        } else {
            throw new StorageException("Max number of players is " + MAX_NUMBER_OF_PLAYERS);
        }
    }

    public void removePlayer(Player player) throws StorageException {
        if (!isEmpty()) {
            players.remove(player);
        } else {
            throw new StorageException("There is no players in the room");
        }
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }

    public boolean isAvailable() {
        return getNumberOfPlayers() < MAX_NUMBER_OF_PLAYERS && !inGame;
    }


    public void shuffleBank() {
        DominoShuffle.shuffle(dominoBank);
    }

    public void createAndShuffleBank() {
        dominoBank.createFullStack();
        shuffleBank();
    }

    public class Table {

        private int leftSide;
        private int rightSide;
        private Deque<Domino> dominos;

        public Table() {
            dominos = new ArrayDeque<>();
        }

        public int getLeftSide() {
            return leftSide;
        }

        public int getRightSide() {
            return rightSide;
        }

        public Deque<Domino> getDominos() {
            return dominos;
        }

        public boolean isEmpty() {
            return dominos.isEmpty();
        }

        public void clear() {
            dominos.clear();
        }

        public void addFirstDomino(Domino domino) throws IncorrectValueException {
            if (isEmpty()) {
                dominos.addLast(domino);
                leftSide = domino.getLeft();
                rightSide = domino.getRight();
            } else {
                throw new IncorrectValueException("Unable to add then Table isn't empty");
            }
        }

        public void addToLeftEdge(Domino domino) {
            dominos.addFirst(domino);
            leftSide = domino.getLeft();
        }

        public void addToRightEdge(Domino domino) {
            dominos.add(domino);
            rightSide = domino.getRight();
        }

        public String  toString() {
            if (isEmpty()) {
                return "there is no domino on the table";
            } else {
                StringBuilder res = new StringBuilder("|" + table.getLeftSide() + ":" + table.getRightSide() + "||TABLE||");
                for (Domino domino : dominos) {
                    res.append(domino.toString());
                    res.append("|");
                }
                return res.toString();
            }
        }
    } // end Table

    public class DominoBank {

        private ArrayList<Domino> dominos;

        public DominoBank() {
            this.dominos = new ArrayList<>();
        }

        public DominoBank(ArrayList<Domino> dominos) {
            this.dominos = dominos;
        }

        public void setDominos(ArrayList<Domino> dominos) {
            this.dominos = dominos;
        }

        public ArrayList<Domino> getDominos() {
            return dominos;
        }

        public int getNumberOfDominos() {
            return dominos.size();
        }

        public boolean isBankEmpty() {
            return dominos.isEmpty();
        }

        public void createFullStack() {
            dominos = DominoCreator.createList();
        }

        public Domino takeFirstDomino() throws StorageException {
            Domino res;
            if (!isEmpty()) {
                res = dominos.remove(0);
            } else {
                throw new StorageException("There is no domino in the storage");
            }
            return res;
        }

        public String bankToString() {
            if (isBankEmpty()) {
                return "there is no domino in bank";
            } else {
                StringBuilder res = new StringBuilder("|BANK||");
                for (Domino domino : dominos) {
                    res.append(domino.toString());
                    res.append("|");
                }

                return res.toString();
            }
        }

    } // end DominoBank
}
