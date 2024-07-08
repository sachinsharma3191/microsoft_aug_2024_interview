package org.example.array;

public class MissingPositiveInteger {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(findMissingPositive(nums)); // Output: 2

        int[] nums2 = {1, 2, 0};
        System.out.println(findMissingPositive(nums2)); // Output: 3

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(findMissingPositive(nums3)); // Output: 1
    }

    public static int findMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Segregate positive numbers from non-positive numbers
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Identify the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers from 1 to n are present, then the missing number is n+1
        return n + 1;
    }
}
