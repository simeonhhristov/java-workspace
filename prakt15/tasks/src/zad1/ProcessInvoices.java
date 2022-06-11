package zad1;

// Exercise 17.11: ProcessInvoices.java
// Processing Invoices with lambdas and streams.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessInvoices
{
    public static void main(String[] args)
    {
        Invoice[] invoices = {
                new Invoice(83, "Electric sander", 7, 57.98),
                new Invoice(24, "Power saw", 18, 99.99),
                new Invoice(7, "Sledge hammer", 11, 21.50),
                new Invoice(77, "Hammer", 76, 11.99),
                new Invoice(39, "Lawn mower", 3, 79.50),
                new Invoice(68, "Screwdriver", 106, 6.99),
                new Invoice(56, "Jig saw", 21, 11.00),
                new Invoice(3, "Wrench", 34, 7.50)
        };

        System.out.println("Invoices sorted by part description:");
        //Stream.of(invoices);
//        Arrays.stream(invoices)
//                .sorted((invoice1, invoice2)-> invoice1.getPartDescription().compareTo(invoice2.getPartDescription()))
//                .forEach(invoice -> System.out.println(invoice));

        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);


        System.out.printf("%nnInvoices sorted by price:%n");
//        Arrays.stream(invoices)
//                        .sorted((invoice1, invoice2) -> Double.compare(invoice1.getPrice(), invoice2.getPrice()))
//                                .forEach(invoice->System.out.println(invoice));
        Arrays.stream(invoices)
                .sorted(Comparator.comparingDouble(Invoice::getPrice))
                .forEach(System.out::println);

        System.out.printf("%nInvoices mapped to description and quantity:%n");
        //map
        //Map

        Arrays.stream(invoices)
                        .collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity))
                                .entrySet().stream()
                                    .sorted(Map.Entry.comparingByValue())
                                         .forEach(entry ->System.out.printf("%s %d\n", entry.getKey(), entry.getValue()));


        System.out.printf("%nInvoices mapped to description and invoice amount:%n");
        Arrays.stream(invoices)
                .collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity))
                .entrySet().stream().filter(entry -> entry.getValue() >= 200 && entry.getValue() <= 500)
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->System.out.printf("%s %d\n", entry.getKey(), entry.getValue()));



        System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
    }
}