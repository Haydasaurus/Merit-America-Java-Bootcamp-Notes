package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        // Only allow the withdraw if the balance isn't going to go below -$100
        if (getBalance() - amountToWithdraw > -100) {
            // Withdraw the $$
            super.withdraw(amountToWithdraw);
            // If the balance dips below 0, assess $10 charge
            if (getBalance() < 0) {
                super.withdraw(10);
            }
        }
        return getBalance();
    }

}