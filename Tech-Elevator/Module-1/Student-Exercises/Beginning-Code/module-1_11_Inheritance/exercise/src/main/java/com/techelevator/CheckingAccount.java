package com.techelevator;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    @Override
    public int withdraw(int amountToWithdraw) {
        int withdrawFee = 10;
        if(this.getBalance() - amountToWithdraw > -100) {
            if(this.getBalance() > 0) {
                super.withdraw(amountToWithdraw);
            } else {
                amountToWithdraw += withdrawFee;
                super.withdraw(amountToWithdraw);
            }
        }
        return this.getBalance();
    }
}