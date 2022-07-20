package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        // only perform transaction of positive $ and room for fee
        if (getBalance() - amountToWithdraw >= 2) {
            super.withdraw(amountToWithdraw);
            // Assess $2 fee if it goes below $150
            if (getBalance() < 150) {
                super.withdraw(2);
            }
        }
        return getBalance();
    }

}