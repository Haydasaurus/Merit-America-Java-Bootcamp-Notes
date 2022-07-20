package com.techelevtor;

// Step 7: Create the MasterCard class
public class MasterCard extends CreditCard {

    @Override
    public void validate() throws CreditCardValidationException {
        super.validate();
        // MasterCard numbers always begin with '5'.
        if (getNumber().charAt(0) != '5') {
            throw new CreditCardValidationException("'" + getNumber() + "' - Invalid MasterCard card number, must begin with '5'.");
        }
    }

}
