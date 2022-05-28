package task11b;

import task11a.StringTooLongException;

import java.util.Scanner;

public class StringTooLongExceptionTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("DONE")) {
            System.out.println("Enter text:");
            userInput = input.nextLine();

            if (userInput.length() >= 20) {
                try {
                    throw new StringTooLongException();
                } catch (StringTooLongException e) {
                    System.err.println(e.getMessage());
                }

            }
        }
    }
}
