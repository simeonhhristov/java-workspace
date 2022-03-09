package com.company;

import java.util.Scanner;

public class Main {
    static String toBase4(int decimal){
        int rem;
        String base4="";
        char base4Chars[]={'0','1','2','3'};

        //logic of decimal to base4 conversion
        while(decimal>0) {
            rem = decimal % 4;
            base4 = base4Chars[rem] + base4;
            decimal = decimal / 4;
        }

        return base4;
    }

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        int number;
        System.out.print("Enter number:");
        number  = input.nextInt();

        String base4Conversion = toBase4(number);
        String nucleotides = "ACGT";
        String result = "";

        //generate nucleotide sequence from the numbers
        for (int i = 0; i < base4Conversion.length(); i++ ){

           result = result + nucleotides.charAt(Character.getNumericValue(base4Conversion.charAt(i)));
        }

        System.out.println(result);
    }
}
