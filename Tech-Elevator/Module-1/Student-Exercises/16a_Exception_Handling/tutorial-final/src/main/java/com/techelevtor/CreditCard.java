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

    public void validate() throws CreditCardValidationException { // Step 3: Throw and catch CreditCardValidationException

        // Step 4: Validate cardholder name
        if (lastName == null || lastName.length() == 0 || firstName == null || firstName.length() == 0) {
            throw new CreditCardValidationException("'" + firstName + " " + lastName + "' - Cardholder name is invalid, must provide first and last names.");
        }

        // Step 5: Validate card number
        if (number == null || (number.length() != 13 && number.length() != 16) || !isDigits(number)) {
            throw new CreditCardValidationException("'" + number + "' - Card number is too short or too long, or not all digits.");
        }

        // Step 6: Validate security code
        if (securityCode == null || securityCode.length() != 3 || !isDigits(securityCode)) {
            throw new CreditCardValidationException("'" + securityCode + "' - Security code is too short or too long, or not all digits.");
        }

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
