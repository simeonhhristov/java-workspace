package com.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SquareMatrix {
    private int[][] dataArray;

    private void fillMatrix(int size) {
        Random rand = new Random();
        int value;

        //fill with random numbers
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                value = rand.nextInt(9);
                this.dataArray[i][j] = value;
            }
        }
    }

    public SquareMatrix() {
        //initialize 2x2 matrix
        this.dataArray = new int[2][2];
        fillMatrix(2);
    }

    public SquareMatrix(SquareMatrix other) {
        int size = other.dataArray.length;
        this.dataArray = new int[size][size];

        for (int i = 0; i < size; i++) {
            //copy data from source matrix to the new one
            System.arraycopy(other.dataArray[i], 0, this.dataArray[i], 0, size);
        }
    }

    public SquareMatrix(int size) {
        //throw exception on invalid data
        if (size < 2 || size > 12) {
            throw new RuntimeException("Invalid size");
        }

        //create new matrix
        this.dataArray = new int[size][size];
        fillMatrix(size);
    }

    public int[][] getDataArray() {
        //initialize new matrix
        int size = this.dataArray.length;
        int[][] copy = new int[size][size];

        for (int i = 0; i < size; i++) {
            //copy data from source matrix to the new one
            System.arraycopy(copy[i], 0, this.dataArray[i], 0, size);
        }

        return copy;
    }

    public void setDataArray(int[][] dataArray) {
        if (dataArray.length != dataArray[0].length) {
            if (dataArray.length < 2 || dataArray.length > 12) {
                throw new RuntimeException("Invalid matrix size");
            }
            throw new RuntimeException("Matrix must be square");
        }

        //initialize new matrix
        int size = dataArray.length;
        this.dataArray = new int[size][size];

        //copy matrix values
        for (int i = 0; i < size; i++) {
            //copy data from source matrix to the new one
            System.arraycopy(dataArray[i], 0, this.dataArray[i], 0, size);
        }
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();

        for (int[] ints : this.dataArray) {
            value.append(Arrays.toString(ints));
            value.append('\n');
        }
        return value.toString();
    }

    public int findMaxSum() {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < this.dataArray.length - 1; i++) {
            for (int j = 0; j < this.dataArray.length - 1; j++) {
                int tl = this.dataArray[i][j];
                int tr = this.dataArray[i][j + 1];
                int bl = this.dataArray[i + 1][j];
                int br = this.dataArray[i + 1][j + 1];

                sum = Integer.max(tl + tr + bl + br, sum);
            }
        }

        return sum;
    }

    public void printAll() {
        int maxSum = findMaxSum();
        ArrayList<Integer> rows = new ArrayList<Integer>(0);
        ArrayList<Integer> cols = new ArrayList<Integer>(0);

        for (int i = 0; i < this.dataArray.length - 1; i++) {
            for (int j = 0; j < this.dataArray.length - 1; j++) {
                int tl = this.dataArray[i][j];
                int tr = this.dataArray[i][j + 1];
                int bl = this.dataArray[i + 1][j];
                int br = this.dataArray[i + 1][j + 1];

                if (tl + tr + bl + br == maxSum) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        System.out.println("Submatrices with maximum sum: ");
        for (int i = 0; i < rows.size(); i++) {
            System.out.printf("[%d, %d] ", rows.get(i), cols.get(i));
        }
    }
}
