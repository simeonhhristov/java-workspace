package com.homework;

public class MonetaryCoin extends Coin {
    private int value;

    MonetaryCoin(int value, Face face) {
        super(face);
        setValue(value);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new RuntimeException("Invalid value");
        }
        this.value = value;
    }
}
