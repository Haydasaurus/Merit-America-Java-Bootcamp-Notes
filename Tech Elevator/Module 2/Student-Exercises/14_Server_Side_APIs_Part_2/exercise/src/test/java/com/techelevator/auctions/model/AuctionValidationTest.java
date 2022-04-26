package com.techelevator.auctions.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class AuctionValidationTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    public AuctionValidationTest() {

    }

    @Test
    public void should_have_no_violations() {
        Auction auction = new Auction("TEST_TITLE", "TEST_DESC", "TEST_USER", 99);

        Set<ConstraintViolation<Auction>> violations = validator.validate(auction);

        assertTrue(violations.isEmpty());
    }


    @Test
    public void titleShouldNotBeBlank() {
        Auction auction = new Auction("", "TEST_DESC", "TEST_USER", 99);
        Set<ConstraintViolation<Auction>> violations = validator.validate(auction);
        assertEquals(violations.size(), 1);

        ConstraintViolation<Auction> violation = violations.iterator().next();
        assertEquals("The title field should not be blank.", violation.getMessage());
        assertEquals("title", violation.getPropertyPath().toString());
    }

    @Test
    public void descriptionShouldNotBeBlank() {
        Auction auction = new Auction("TEST_TITLE", "", "TEST_USER", 99);
        Set<ConstraintViolation<Auction>> violations = validator.validate(auction);
        assertEquals(violations.size(), 1);

        ConstraintViolation<Auction> violation = violations.iterator().next();
        assertEquals("The description field should not be blank.", violation.getMessage());
        assertEquals("description", violation.getPropertyPath().toString());
    }

    @Test
    public void userShouldNotBeBlank() {
        Auction auction = new Auction("TEST_TITLE", "TEST_DESC", "", 99);
        Set<ConstraintViolation<Auction>> violations = validator.validate(auction);
        assertEquals(violations.size(), 1);

        ConstraintViolation<Auction> violation = violations.iterator().next();
        assertEquals("The user field should not be blank.", violation.getMessage());
        assertEquals("user", violation.getPropertyPath().toString());
    }

    @Test
    public void currentBidShouldBeGreaterThanZero() {
        Auction auction = new Auction("TEST_TITLE", "TEST_DESC", "TEST_USER", 0);
        Set<ConstraintViolation<Auction>> violations = validator.validate(auction);
        assertEquals(violations.size(), 1);

        ConstraintViolation<Auction> violation = violations.iterator().next();
        assertEquals("The currentBid field should be greater than 0.", violation.getMessage());
        assertEquals("currentBid", violation.getPropertyPath().toString());
    }

    @Test
    public void currentBidShouldBeGreaterThanZeroWhenNotSet() {
        Auction auction = new Auction();
        auction.setTitle("TEST_TITLE");
        auction.setDescription("TEST_DESC");
        auction.setUser("TEST_USER");
        Set<ConstraintViolation<Auction>> violations = validator.validate(auction);
        assertEquals(violations.size(), 1);

        ConstraintViolation<Auction> violation = violations.iterator().next();
        assertEquals("The currentBid field should be greater than 0.", violation.getMessage());
        assertEquals("currentBid", violation.getPropertyPath().toString());
    }


}