package com.geometry.utils;

import com.geometry.types.Circle;
import com.geometry.types.Cylinder;
import com.geometry.types.Point;

import java.util.Random;

public class SelectionSortTest {
    private static Comparable[] arrComparable = new Comparable[9];

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int x = 10 + random.nextInt(41);
            int y = 10 + random.nextInt(41);
            Point point = new Point(x, y);
            arrComparable[i] = point;
        }

        for (int i = 3; i < 6; i++) {
            int radius = 10 + random.nextInt(21);
            Point point = (Point) arrComparable[i - 3];
            Circle circle = new Circle(point.getX(), point.getY(), radius);
            arrComparable[i] = circle;
        }

        for (int i = 6; i < 9; i++) {
            int height = 10 +  random.nextInt(51);
            Circle circle = (Circle) arrComparable[i - 3];
            Cylinder cylinder = new Cylinder(circle.getX(), circle.getY(), circle.getRadius(), height);
            arrComparable[i] = cylinder;
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(arrComparable[i].toString());
        }

        System.out.println("\nSorted");
        SelectionSort.sortArray(arrComparable);

        for (int i = 0; i < 9; i++) {
            System.out.println(arrComparable[i].toString());
        }
    }
}
