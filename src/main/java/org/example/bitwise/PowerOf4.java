package org.example.bitwise;

public class PowerOf4 {

    public static void main(String[] args) {
        int n1 = 16;
        System.out.println(isPowerOfFour(n1)); // true

        int n2 = 15;
        System.out.println(isPowerOfFour(n2)); // false
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        // Check if n is a power of two and the only set bit is in an even position
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
