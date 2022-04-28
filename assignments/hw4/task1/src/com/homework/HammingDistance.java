package com.homework;

import java.util.Scanner;

public class HammingDistance {
    public static int calculateHammingDistance(byte number1, byte number2){
        byte result =(byte) (number1 ^ number2);
        return Integer.bitCount(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        byte number1 = scanner.nextByte();

        System.out.print("Enter second number: ");
        byte number2 = scanner.nextByte();

        int result = calculateHammingDistance(number1, number2);

        System.out.printf("%d and %d differ in %d bit position/s, therefore their hamming distance is %d", number1, number2,
                result, result);
        //System.out.println(calculateHammingDistance(number1, number2));
    }
}
