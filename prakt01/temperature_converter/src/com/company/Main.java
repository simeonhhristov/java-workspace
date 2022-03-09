package com.company;

import java.util.Scanner;

public class Main {
    static double toCelsius(int degrees){
        double result;
        result = (5.0 / 9.0) * (degrees - 32);
        return result;
    }

    static double toFahrenheit(int degrees){
        double result;
        result = (9.0 / 5.0) * (degrees + 32);
        return result;
    }

    public static void main(String[] args) {
	    //scanner to get user input
        Scanner input = new Scanner(System.in);

        char unit;
        int inputDegrees;
        int conversionValue;

        System.out.print("Enter unit you want for convert to (C - celsius, F - Fahrenheit) : ");
        unit = input.next().charAt(0);

        System.out.print("Enter degrees you want to convert:");
        inputDegrees = input.nextInt();

        if(unit == 'F' || unit == 'f'){
            System.out.println(toFahrenheit(inputDegrees));
        }
        else if (unit == 'C' || unit == 'c'){
            System.out.println(toCelsius(inputDegrees));
        }
        else{
            System.out.println("Invalid data.");
        }
    }
}
