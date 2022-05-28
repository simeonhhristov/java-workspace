package task4;

public class LinearSearchTest {
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
        for (int i = 0; i < list.length; i++) {
            if(list[i].compareTo(key) == 0){
                return i;
            }
        }
        return  - 1;
    }

    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        System.out.printf("index of 3 is %d\n", linearSearch(integers, 3));


    }
}
