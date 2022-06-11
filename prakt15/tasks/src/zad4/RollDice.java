package zad4;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RollDice {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream.rangeClosed(1, 6_000_000)
                .mapToObj(i -> random.nextInt(1, 7))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.printf("%-5s%-15s\n", entry.getKey(), entry.getValue()));
    }
}
