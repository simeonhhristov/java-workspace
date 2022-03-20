package com;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    printListOfAllFriday13();
    }

    private  static void printListOfAllFriday13(){
        Random random = new Random();
        int year = 1900 + random.nextInt(121); // 2020 - 1900  + 1 = 121
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");

        for (int i = 0; i < 12; i++) {
            LocalDate date = LocalDate.of(year, i + 1, 13);

            if (date.getDayOfWeek() == DayOfWeek.FRIDAY){
                System.out.println(date);
            }
        }

    }
}
