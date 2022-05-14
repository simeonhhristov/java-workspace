package test;

import com.Functions;
import com.Tabulate;
import services.Computable;

public class TabulateTest {
    public static void main(String[] args) {
        Functions functions = new Functions();
        Tabulate tabulate = new Tabulate(functions.getSinFunction());
        tabulate.tabulate(1, 10, 10);

        System.out.println();

        Tabulate.tabulateFunctions(1, 10, 30, new Computable() {
            @Override
            public double function(double x) {
                return 1.0 / x;
            }
        });
    }
}
