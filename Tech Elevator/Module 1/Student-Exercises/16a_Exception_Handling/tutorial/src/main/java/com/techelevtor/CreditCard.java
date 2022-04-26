package com.techelevtor;

public class CreditCard {

    private String lastName;
    private String firstName;
    private String number;
    private String securityCode;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public void validate() throws Exception { // Step 3: Throw and catch CreditCardValidationException

        // Step 4: Validate cardholder name

        // Step 5: Validate card number

        // Step 6: Validate security code

    }

    @Override
    public String toString() {
        return "Name: '" + firstName + " " + lastName + "'" +
                ", Number: " + number +
                ", Security Code: " + securityCode;
    }

    private boolean isDigits(String str) {
        for (char ch: str.toCharArray()) {
            if ((ch < '0') || (ch > '9')) {
                return false;
            }
        }
        return true;
    }
}
