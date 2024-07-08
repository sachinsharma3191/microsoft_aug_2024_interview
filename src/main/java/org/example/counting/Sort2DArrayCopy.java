package org.example.counting;

public class Sort2DArrayCopy {

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

        // Flatten the 2D array into a 1D array
        int[] flatArray = new int[totalElements];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[index++] = array[i][j];
            }
        }

        // Perform in-place sort using two pointers
        int left = 0;
        int right = totalElements - 1;

        while (left < right) {
            // Move left pointer to the right until we find a 1
            while (left < right && flatArray[left] == 0) {
                left++;
            }

            // Move right pointer to the left until we find a 0
            while (left < right && flatArray[right] == 1) {
                right--;
            }

            // Swap elements
            if (left < right) {
                flatArray[left] = 0;
                flatArray[right] = 1;
                left++;
                right--;
            }
        }

        // Copy the sorted 1D array back into the 2D array
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = flatArray[index++];
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
