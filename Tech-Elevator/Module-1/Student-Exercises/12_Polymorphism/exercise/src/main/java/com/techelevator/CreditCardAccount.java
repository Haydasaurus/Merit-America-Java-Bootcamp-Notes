package com.techelevator;

public class CreditCardAccount implements Accountable{

    private String accountHolder;
    private String accountNumber;
    private int debt;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    public int pay(int amountToPay) {
        return this.debt -= amountToPay;
    }

    public int charge(int amountToCharge) {
        return this.debt += amountToCharge;
    }

    @Override
    public int getBalance() {
        return this.debt * -1;
    }


    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }
}