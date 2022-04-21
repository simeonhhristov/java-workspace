package com.homework;

import java.util.Arrays;

public class RouteCipher {

    private int key;

    public RouteCipher(int key) {
        this.setKey(key);
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        // set minimum key value in range [-inf; -2] U [2; inf]
        //would be useless if we have 1 or 0 columns (personal opinion...)
        if (Math.abs(key) <= 1) {
            //respect choice of starting point
            if (Integer.signum(key) == 1) {
                this.key = 2;
                return;
            }

            this.key = -2;
            return;
        }

        this.key = key;
    }

    public String encrypt(String plainText) {
        int cols = Math.abs(this.key);
        //calculate number of rows
        int rows = (int) Math.ceil(plainText.length() / (double) cols);

        char[][] grid = new char[rows][cols];
        generateGrid(plainText, grid);
        char[] resultArr = new char[rows * cols];

        if (this.key > 0) {
            return encryptFromTop(grid, resultArr);
        }

        return encryptFromBottom(grid, resultArr);
    }

    public String decrypt(String cipherText) {
        int cols = Math.abs(this.key);
        //calculate number of rows
        int rows = (int) Math.ceil(cipherText.length() / (double) cols);

        //fill a new grid
        char[][] grid = new char[rows][cols];

        if (this.key > 0) {
            decryptFromTop(grid, cipherText.toCharArray());
        } else {
            decryptFromBottom(grid, cipherText.toCharArray());
        }

        //read the grid
        String deciphered = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                deciphered += grid[i][j];
            }
        }

        //trim to eliminate added spaces at the back
        return deciphered.trim();
    }

    private String encryptFromTop(char[][] grid, char[] resultArr) {
        int j = 0; //iterator
        int i;
        int startingRow = 0; // starting row idx;
        int startingCol = 0; // starting column idx
        int endingRow = grid.length; // ending row idx;
        int endingCol = grid[0].length; // ending column idx

        while (startingRow < endingRow && startingCol < endingCol) {
            // get the first column
            for (i = startingRow; i < endingRow; ++i, j++) {
                resultArr[j] = grid[i][startingCol];
            }
            startingCol++;

            // get the last row from the remaining rows
            for (i = startingCol; i < endingCol; ++i, j++) {
                resultArr[j] = grid[endingRow - 1][i];
            }
            endingRow--;

            // get the last column from the remaining columns
            if (startingCol < endingCol) {
                for (i = endingRow - 1; i >= startingRow; --i, j++) {
                    resultArr[j] = grid[i][endingCol - 1];
                }
                endingCol--;
            }

            // get the first row from the remaining rows
            if (startingRow < endingRow) {
                for (i = endingCol - 1; i >= startingCol; --i, j++) {
                    resultArr[j] = grid[startingRow][i];
                }
                startingRow++;
            }
        }
        return new String(resultArr);
    }

    private String encryptFromBottom(char[][] grid, char[] resultArr) {
        int j = 0; //iterator
        int i;
        int startingRow = 0; // starting row idx;
        int startingCol = 0; // starting column idx
        int endingRow = grid.length; // ending row idx;
        int endingCol = grid[0].length; // ending column idx

        while (startingRow < endingRow && startingCol < endingCol) {
            // get the last column
            for (i = endingRow - 1; i >= startingRow; --i, j++) {
                resultArr[j] = grid[i][endingCol - 1];
            }
            endingCol--;

            // get the top row from the remaining rows
            for (i = endingCol - 1; i >= startingCol; --i, j++) {
                resultArr[j] = grid[startingRow][i];
            }
            startingRow++;

            // get the first column from the remaining columns
            if (startingCol < endingCol) {
                for (i = startingRow; i < endingRow; ++i, j++) {
                    resultArr[j] = grid[i][startingCol];
                }
                startingCol++;
            }

            // get the last row from the remaining rows
            if (startingRow < endingRow) {
                for (i = startingCol; i < endingCol; ++i, j++) {
                    resultArr[j] = grid[endingRow - 1][i];
                }
                endingRow--;
            }
        }
        return new String(resultArr);
    }

    private void decryptFromTop(char[][] grid, char[] cipherText) {
        int j = 0; //iterator
        int i;
        int startingRow = 0; // starting row idx;
        int startingCol = 0; // starting column idx
        int endingRow = grid.length; // ending row idx;
        int endingCol = grid[0].length; // ending column idx

        while (startingRow < endingRow && startingCol < endingCol) {
            // get the first column
            for (i = startingRow; i < endingRow; ++i, j++) {
                grid[i][startingCol] = cipherText[j];
            }
            startingCol++;

            // get the last row from the remaining rows
            for (i = startingCol; i < endingCol; ++i, j++) {
                grid[endingRow - 1][i] = cipherText[j];
            }
            endingRow--;

            // get the last column from the remaining columns
            if (startingCol < endingCol) {
                for (i = endingRow - 1; i >= startingRow; --i, j++) {
                    grid[i][endingCol - 1] = cipherText[j];
                }
                endingCol--;
            }

            // get the first row from the remaining rows
            if (startingRow < endingRow) {
                for (i = endingCol - 1; i >= startingCol; --i, j++) {
                    grid[startingRow][i] = cipherText[j];
                }
                startingRow++;
            }
        }
    }

    private void decryptFromBottom(char[][] grid, char[] cipherText) {
        int j = 0; //iterator
        int i;
        int startingRow = 0; // starting row idx;
        int startingCol = 0; // starting column idx
        int endingRow = grid.length; // ending row idx;
        int endingCol = grid[0].length; // ending column idx

        while (startingRow < endingRow && startingCol < endingCol) {
            // get the last column
            for (i = endingRow - 1; i >= startingRow; --i, j++) {
                grid[i][endingCol - 1] = cipherText[j];
            }
            endingCol--;

            // get the top row from the remaining rows
            for (i = endingCol - 1; i >= startingCol; --i, j++) {
                grid[startingRow][i] = cipherText[j];
            }
            startingRow++;

            // get the first column from the remaining columns
            if (startingCol < endingCol) {
                for (i = startingRow; i < endingRow; ++i, j++) {
                    grid[i][startingCol] = cipherText[j];
                }
                startingCol++;
            }

            // get the last row from the remaining rows
            if (startingRow < endingRow) {
                for (i = startingCol; i < endingCol; ++i, j++) {
                    grid[endingRow - 1][i] = cipherText[j];
                }
                endingRow--;
            }
        }
    }

    private void generateGrid(String plainText, char[][] grid) {
        //transform string to array of chars
        char[] cipherTextChars = plainText.toCharArray();
        int rows = grid.length;
        int cols = grid[0].length;

        int currentChar = 0;
        //fill grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (currentChar != cipherTextChars.length) {
                    grid[i][j] = cipherTextChars[currentChar];
                    currentChar++;
                    continue;
                }
                grid[i][j] = ' ';
            }
        }
    }
}
