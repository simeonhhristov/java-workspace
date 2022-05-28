package task3;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesTest {


    public static <E>ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> uniques = new ArrayList<>();

        for (E item: list) {
            if(!uniques.contains(item)){
                uniques.add(item);
            }
        }

        return uniques;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers =new ArrayList<>(List.of(1,1,1,1,2,3,4,5,6, 4, 2,2,1));
        System.out.printf("list : %s", integers);
        System.out.printf("unique: %s", removeDuplicates(integers));
    }
}
