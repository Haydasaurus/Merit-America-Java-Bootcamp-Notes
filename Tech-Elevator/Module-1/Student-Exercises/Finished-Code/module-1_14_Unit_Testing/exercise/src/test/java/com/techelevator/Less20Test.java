package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Test {

    private Less20 less20;

    @Before
    public void setUpTests() {
        less20 = new Less20();
    }

    @Test
    public void test_Less20() {
        Assert.assertTrue(less20.isLessThanMultipleOf20(19));
        Assert.assertTrue(less20.isLessThanMultipleOf20(59));
        Assert.assertTrue(less20.isLessThanMultipleOf20(38));
        Assert.assertTrue(less20.isLessThanMultipleOf20(78));
        Assert.assertFalse(less20.isLessThanMultipleOf20(40));
        Assert.assertFalse(less20.isLessThanMultipleOf20(17));
    }
}