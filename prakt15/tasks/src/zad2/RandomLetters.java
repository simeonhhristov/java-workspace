package zad2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLetters {
    public static void main(String[] args) {
        Random random = new Random();
        List<Character> list = IntStream.range(0, 30)
                .mapToObj(i -> (char) ('A' + random.nextInt(26)))
                .collect(Collectors.toList());

        List<Character> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);

        sorted = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sorted);

        sorted = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.printf("%c - %d\n", entry.getKey(), entry.getValue()));

    }
}
