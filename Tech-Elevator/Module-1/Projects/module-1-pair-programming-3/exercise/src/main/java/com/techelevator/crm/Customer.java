package com.techelevator.crm;
import com.techelevator.Billable;
import com.techelevator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person implements Billable {                      //Step Five & Six Pt1 - Create customer Class, implement Billable

    private String phoneNumber;                                                 //Step Five Pt2 - Property phoneNumber (Customer's phone number)
    private List<String> pets = new ArrayList<>();                              //Step Five Pt2 - Property pets (Customer pets)

    public String getPhoneNumber() {                                            //Step Five Pt2 - Getter for phone number
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {                            //Step Five Pt2 - Setter for phone number
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPets() {                                             //Step Five Pt2 - Getter for pets
        return pets;
    }

    public void setPets(List<String> pets) {                                    //Step Five Pt2 - Setter for pets
        this.pets = pets;
    }

    public Customer(String firstName, String lastName, String phoneNumber) {    //Step Five Pt3 - Constructor (Accepts FirstName LastName & PhoneNumber as Strings)
        super(firstName, lastName);
        setPhoneNumber(phoneNumber);
    }

    public Customer(String firstName, String lastName) {                        //Step Five Pt3 - Constructor (Accepts FirstName & LastName as Strings)
        super(firstName, lastName);
        setPhoneNumber("");
    }

    public double getBalanceDue(Map<String, Double> servicesRendered) {
        int balanceSum = 0;
        for (Map.Entry<String,Double> service : servicesRendered.entrySet()) {
            balanceSum += service.getValue();
        }
        return balanceSum;
    }

}