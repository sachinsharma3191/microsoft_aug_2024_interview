package org.example.design;

import java.util.*;

class Bank {

    private Map<Integer, Long> accounts;
    private long balance[];
    private int size;

    public Bank(long[] balance) {
        this.balance = balance;
        this.accounts = new HashMap<>();
        this.init();
    }

    private void init() {
        for (int i = 0; i < balance.length; i++) {
            accounts.put(i + 1, balance[i]);
        }
        System.out.println();
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!accounts.containsKey(account1) || !accounts.containsKey(account2)) return false;
        boolean canWithdraw = withdraw(account1, money);
        if (!canWithdraw) return false;
        boolean canDeposit = deposit(account2, money);
        return canDeposit;
    }

    public boolean deposit(int account, long money) {
        if (!accounts.containsKey(account)) return false;
        accounts.put(account, accounts.get(account) + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!accounts.containsKey(account)) return false;
        long curBalance = accounts.get(account);
        if (curBalance - money < 0) return false;
        accounts.put(account, curBalance - money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */

public class SimpleBankSystem2043 {

    public static void main(String[] args) {
        long[] initialBalances = {1000, 2000, 3000, 4000, 5000};
        Bank bank = new Bank(initialBalances);

        // Test transactions
        System.out.println(bank.deposit(3, 500));   // true
        System.out.println(bank.withdraw(1, 1000)); // true
        System.out.println(bank.transfer(2, 4, 1500)); // true
        System.out.println(bank.withdraw(5, 6000)); // false
        System.out.println(bank.transfer(1, 6, 100)); // false
    }
}
