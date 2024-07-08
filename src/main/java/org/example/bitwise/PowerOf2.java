package org.example.bitwise;

public class PowerOf2 {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n)); // true

        n = 18;
        System.out.println(isPowerOfTwo(n)); // false
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

}
