package com.company;

import java.util.Scanner;

public class Main {

    public  static void deSwap(int arr[]){
        int temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;

        temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;
    }

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        int number;
        String result = "";
        int digits[] = {0, 0, 0, 0};

        System.out.print("Enter number to decrypt: ");
        number = input.nextInt();

        //separate digits
        for(int i = 3; number > 0; i--){
            digits[i] = number % 10;
            number = number / 10;
        }

        //reverse encryption
        deSwap(digits);
        for (int i = 0; i < 4; i++)
        {
            digits[i] = (digits[i] + 3) % 10;
        }

        for (int i = 0; i < 4; i++){
            result = result + Character.forDigit(digits[i], 10);
        }
        System.out.println("Decrypted: " + result);
    }
}
