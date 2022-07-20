package com.techelevator;

public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int withdrawFee = 2;
        if(this.getBalance() - amountToWithdraw >= 0) {
            if(this.getBalance() - amountToWithdraw < 150) {
                amountToWithdraw += withdrawFee;
                super.withdraw(amountToWithdraw);
            } else {
                super.withdraw(amountToWithdraw);
            }
        }
        return this.getBalance();
    }
}