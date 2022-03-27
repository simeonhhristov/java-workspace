package com.company;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //simulate probabilities for each number
        int[] elements = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3};
        int[] occurrences = drawRandomNumbers(elements, 10000);
        NumberFormat nf = NumberFormat.getPercentInstance(Locale.ENGLISH);

        System.out.println("Result:");
        System.out.println("10k iterations:");
        System.out.println("1: " + nf.format(occurrences[0] / 10_000.0));
        System.out.println("2: " + nf.format(occurrences[1] / 10_000.0));
        System.out.println("3: " + nf.format(occurrences[2] / 10_000.0));

        //do 60k iterations
        occurrences = drawRandomNumbers(elements, 60000);
        System.out.println("\n60k iterations:");
        System.out.println("1: " + nf.format(occurrences[0] / 60_000.0));
        System.out.println("2: " + nf.format(occurrences[1] / 60_000.0));
        System.out.println("3: " + nf.format(occurrences[2] / 60_000.0));

    }

    private static int[] drawRandomNumbers(int[] arr, int iterations) {
        int[] occurrences = {0, 0, 0};
        Random random = new Random();

        for (int i = 0; i < iterations; i++) {
            occurrences[arr[random.nextInt(arr.length)] - 1]++;
        }
        return occurrences;
    }
}
