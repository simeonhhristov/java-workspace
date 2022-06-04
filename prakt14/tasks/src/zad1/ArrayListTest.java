package zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListTest{
    // task 1-----------------------------------------------------------------------------
    public static <E extends Comparable<E>> E max(E[][] list)
    {
        E maxElement = list[0][0];

        for (int i = 0; i < list.length; i++) {
           E newMax = Collections.max(Arrays.asList(list[i]));

            if(newMax.compareTo(maxElement) > 0){
                maxElement = newMax;
            }
        }
        return maxElement;
    }

    public static <E> void shuffle(ArrayList<E> list){
        Collections.shuffle(list);
    }

    public  static  <E extends Comparable<E>> E max (ArrayList<E> list){
        return Collections.max(list);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> uniques = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(uniques, list.get(i)) == 0) {
                uniques.add(list.get(i));
            }
        }

        return uniques;
    }
    // task 2.2-----------------------------------------------------------------------------

    public ArrayListTest() {

    }
    public static void main(String[] args) {

    }
}
