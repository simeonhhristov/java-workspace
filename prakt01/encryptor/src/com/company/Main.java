package com.company;

import java.util.Scanner;

public class Main {
    public  static void swap(int arr[]){
        int temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;

        temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;
    }
    static int encrypt(int num){
        int result;
        result = (num + 7) % 10;
        return result;
    }

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        int number;
        System.out.print("Enter 4 digit number to encrypt: ");
        number = input.nextInt();

        int digits[] = {0,0,0,0};

        for (int i = 3; number > 0; i--)
        {
            digits[i] = encrypt(number % 10);
            number = number / 10;
        }
        swap(digits);

        String result = "";
        for (int i = 0; i < 4; i++)
        {
            result  = result + Character.forDigit(digits[i], 10);
        }
        System.out.println("Encryption: " + result);
    }
}
