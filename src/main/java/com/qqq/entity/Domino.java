package com.qqq.entity;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Domino extends Object{
    static AtomicInteger nextId = new AtomicInteger();
    private long dominoId;
    private int left;
    private int right;
    private boolean isAvailable;

    {
        dominoId = nextId.incrementAndGet();
        isAvailable = false;
    }

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public long getDominoId() {
        return dominoId;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isSame(int left, int right) {
        return this.left == left || this.left == right || this.right == left || this.right == right;
    }

    public boolean isSame(int leftOrRight) {
        return this.left == leftOrRight || this.right == leftOrRight ;
    }

    public int getCodedValues() {
        // 7 - number of values 0 1 ... 6
        return left * 7 + right;
    }

    public int getSum() {
        return left + right;
    }

    public boolean isDouble() {
        return left == right;
    }

    @Override
    public String toString() {
        return "(" + isAvailable + ")--" + "[" + left + " : " + right + "]";
    }

    public boolean equals(int left, int right) {
        return this.left == left && this.right == right || this.left == right && this.right == left;
    }

    public void swap() {
        int temp = left;
        left = right;
        right = temp;
    }
}
