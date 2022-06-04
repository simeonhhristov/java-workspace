package t2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {

    private ArrayList<String> list;

    public ArrayListTest()
    {
        list = new ArrayList<>(List.of("Лили", "Мария", "Георги", "Илия", "Цвета", "Георги"));
    }

    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>(List.of("Лили", "Мария", "Георги", "Илия", "Цвета", "Георги"));
        ArrayList<String> bList = new ArrayList<>(List.of("Лили", "Мария", "Георги", "Цвета", "Нещо"));

        Iterator<String> aIterator = aList.iterator();
        Iterator<String> bIterator;

        while (aIterator.hasNext()){
            String aItem = aIterator.next();

            bIterator = bList.iterator();

            while (bIterator.hasNext()){
                if(bIterator.next().equals(aItem)){
                    System.out.printf("%s ", aItem);
                    break;
                }
            }

        }

        ArrayListTest test = new ArrayListTest();
        ListIterator<String> nameIterator = test.list.listIterator();

        while (nameIterator.hasNext()) {
            if(nameIterator.next().equals("Георги")) {
                nameIterator.add("Симеон");
                break;
            }
        }
    }
}
