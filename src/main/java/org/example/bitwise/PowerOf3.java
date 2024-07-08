package org.example.bitwise;

public class PowerOf3 {
    public static void main(String[] args) {
        int n1 = 27;
        System.out.println(isPowerOfThree(n1)); // true

        int n2 = 28;
        System.out.println(isPowerOfThree(n2)); // false
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        double logResult = Math.log(n) / Math.log(3);
        return logResult == (int) logResult;
    }
}
