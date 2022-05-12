package com.homework;

import java.util.Random;

public class Coin {
    protected Random rand;
    protected Face face;

    Coin(Face face) {
        setFace(face);
        this.rand = new Random();
    }

    public Face getFace() {
        return this.face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public void flip() {
        if (rand.nextInt(2) == 0) {
            this.face = Face.HEAD;
            return;
        }

        this.face = Face.TAIL;
    }

    public boolean isHeads() {
        return this.face == Face.HEAD;
    }

    @Override
    public String toString() {
        return String.format("Coin: %s", this.face);
    }
}
