package org.example.counting;

public class Sort2DArray {

    public static void main(String[] args) {
        // Example 2D array containing only 0s and 1s
        int[][] array = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        // Print the original array
        System.out.println("Original array:");
        printArray(array);

        // Sort the array
        sort2DArray(array);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void sort2DArray(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int totalElements = rows * cols;

        // Count the number of 0s and 1s
        int countZero = 0;
        int countOne = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }

        // Fill the array with 0s and 1s based on the counts
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (countZero > 0) {
                    array[i][j] = 0;
                    countZero--;
                } else {
                    array[i][j] = 1;
                }
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
