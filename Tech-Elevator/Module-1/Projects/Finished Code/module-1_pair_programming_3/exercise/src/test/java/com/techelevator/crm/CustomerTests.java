package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomerTests {

    @Test
    public void getBalanceDue_returns_amount_to_be_paid() {

        Customer sut = new Customer("John", "Doe");

        Map<String,Double> services = new HashMap<String,Double>();
        services.put("Walking", 20.00);
        services.put("Grooming", 40.00);
        services.put("Sitting", 50.00);

        double totalBill = sut.getBalanceDue(services);

        Assert.assertEquals(110.00, totalBill, 0.001);
    }

}