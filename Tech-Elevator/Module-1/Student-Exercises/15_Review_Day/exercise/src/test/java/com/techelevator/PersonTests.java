package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class PersonTests {

    @Test
    public void fullNameReturnsFirstAndLastName() {
        Person person = new Person("Test","Testerson");
        Assert.assertEquals("The full name returned from person is not in the correct format.",
                "Test Testerson",
                person.getFullName());
    }
}
