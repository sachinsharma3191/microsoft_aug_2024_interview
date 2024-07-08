package org.example.array;

public class MergeSortedArray83 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] nums2 = {2, 4, 6, 8};
        int m = 4; // Number of actual elements in nums1
        int n = 4; // Number of elements in nums2

        merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
