package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        int originalNumber;
        int digits[] = {0,0,0,0,0};
        String resultString;

        System.out.print("Enter a 5 digit number: ");
        originalNumber = input.nextInt();

        if(String.valueOf(originalNumber).length() != 5){
            System.out.println("Incorrect data!");
            System.exit(-1);
        }

        int numCopy = originalNumber;

        for (int i = 4; numCopy > 0; i--){
            digits[i] = numCopy % 10;
            numCopy = numCopy / 10;
        }

        if(digits[0] == digits[4] && digits[1] == digits[3]){
            resultString = "Number is palindrome.";
        }
        else {
            resultString = "Number is not palindrome.";
        }
        System.out.println(resultString);

    }
}
