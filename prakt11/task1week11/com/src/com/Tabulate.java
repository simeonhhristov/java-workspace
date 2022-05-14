package com;

import services.Computable;

import java.util.Scanner;

public class Tabulate {
    private Computable callback;

    public Computable getCallback() {
        return callback;
    }

    public void setCallback(Computable callback) {
        this.callback = callback;
    }

    public Tabulate(Computable callback) {
        this.callback = callback;
    }

    public void tabulate(double a, double b, int steps) {
        Tabulate.tabulateFunctions(a, b, steps, callback);
    }

    public static void tabulateFunctions(double a, double b, int steps, Computable computable) {
        if (a >= b) {
            System.out.println("a must be greater than b");
            return;
        }
        if (steps <= 0) {
            System.out.println("Steps must be a positive number.");
            return;
        }
        if (computable == null) {
            System.out.println("Invalid computable reference.");
            return;
        }

        double step = (b - a) / steps;

        System.out.printf("%-20s%-20s\n", "X", "F(X)");

        int counter = 0;
        Scanner input = new Scanner(System.in);

        for (double x = a; x <= b; x += step) {
            if (counter > 0 && counter % 20 == 0) {
                System.out.println("Press enter to continue");
                input.nextLine();
            }
            System.out.printf("%-20s%-20s\n", x, computable.function(x));
            counter++;
        }

    }
}
