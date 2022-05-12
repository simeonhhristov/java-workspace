package com.homework;

public class MonetaryCoinTest {
    public static void main(String[] args) {
        MonetaryCoin coin1 = new MonetaryCoin(10, Face.HEAD);
        MonetaryCoin coin2 = new MonetaryCoin(20, Face.TAIL);
        MonetaryCoin coin3 = new MonetaryCoin(30, Face.TAIL);

        //sum coin values
        int sum = coin1.getValue() + coin2.getValue() + coin3.getValue();
        System.out.println("SUM: " + sum);

        //if both output the same run again flip is random...
        System.out.println("coin1 before flip: " + coin1.getFace());
        coin1.flip();
        System.out.println("coin1 after flip: " + coin1.getFace());

        //test isHeads() method...
        System.out.println("\nIs coin2's face Head: " + coin2.isHeads());
    }
}
