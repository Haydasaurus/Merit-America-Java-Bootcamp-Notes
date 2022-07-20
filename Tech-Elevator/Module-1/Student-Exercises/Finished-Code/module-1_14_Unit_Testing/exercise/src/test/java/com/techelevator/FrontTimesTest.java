package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {

    private FrontTimes frontTimes;

    @Before
    public void setUpTests() {
        frontTimes = new FrontTimes();
        Assert.assertNotNull(frontTimes);
    }

    @Test
    public void test_FrontTimes() {
        Assert.assertEquals("",frontTimes.generateString("", 3));
        Assert.assertEquals("ababab",frontTimes.generateString("ab",3));
        Assert.assertEquals("aaaa",frontTimes.generateString("a",4));
        Assert.assertEquals("KatKat",frontTimes.generateString("Katherine",2));
        Assert.assertEquals("cak",frontTimes.generateString("cake",1));
    }
}