package org.example.design;

import java.util.*;

class ATM {
    // Array to store the count of banknotes of each denomination
    private long[] banknotes;

    // Denominations of the banknotes
    private static final int[] DENOMINATIONS = {20, 50, 100, 200, 500};

    public ATM() {
        // Initialize the banknotes array with 0, indicating the ATM is empty
        banknotes = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        // Add the deposited banknotes to the ATM's banknotes array
        for (int i = 0; i < 5; i++) {
            banknotes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        // Array to store the number of banknotes to withdraw
        int[] toWithdraw = new int[5];
        // Work backwards from the largest denomination to the smallest
        for (int i = 4; i >= 0; i--) {
            // Calculate the maximum number of banknotes of this denomination that can be used
            int count = (int) Math.min(amount / DENOMINATIONS[i], banknotes[i]);
            toWithdraw[i] = count;
            amount -= count * DENOMINATIONS[i];
        }

        // If amount is not zero, the withdrawal is not possible
        if (amount != 0) {
            return new int[]{-1};
        }

        // Update the banknotes array in the ATM
        for (int i = 0; i < 5; i++) {
            banknotes[i] -= toWithdraw[i];
        }

        return toWithdraw;
    }
}

public class ATMMachineDesign {

    public static void main(String... args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1}); // Deposits 1 $100 banknote, 2 $200 banknotes,
        // and 1 $500 banknote.
        int res[] = atm.withdraw(600);        // Returns [0,0,1,0,1]. The machine uses 1 $100 banknote
        printDenomination(res);
        // and 1 $500 banknote. The banknotes left over in the
        // machine are [0,0,0,2,0].
        atm.deposit(new int[]{0, 1, 0, 1, 1}); // Deposits 1 $50, $200, and $500 banknote.
        // The banknotes in the machine are now [0,1,0,3,1].
        res = atm.withdraw(600);        // Returns [-1]. The machine will try to use a $500 banknote
        printDenomination(res);
        // and then be unable to complete the remaining $100,
        // so the withdraw request will be rejected.
        // Since the request is rejected, the number of banknotes
        // in the machine is not modified.
        res = atm.withdraw(550);        // Returns [0,1,0,0,1]. The machine uses 1 $50 banknote
        printDenomination(res);
        // and 1 $500 banknote.
    }

    private static void printDenomination(int[] res) {
        System.out.println(Arrays.toString(res));
    }
}
