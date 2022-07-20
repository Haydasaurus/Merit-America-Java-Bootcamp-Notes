package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion dateFashion;

    @Before
    public void setUpTests() {
        dateFashion = new DateFashion();
        Assert.assertNotNull(dateFashion);
    }

    @Test
    public void test_DataFashion() {
        Assert.assertEquals(2,dateFashion.getATable(8,8));
        Assert.assertEquals(2,dateFashion.getATable(9,10));
        Assert.assertEquals(2,dateFashion.getATable(9,3));
        Assert.assertEquals(2,dateFashion.getATable(4,8));
        Assert.assertEquals(0,dateFashion.getATable(2,8));
        Assert.assertEquals(0,dateFashion.getATable(9,2));
        Assert.assertEquals(0,dateFashion.getATable(2,1));
        Assert.assertEquals(0,dateFashion.getATable(0,0));
        Assert.assertEquals(1,dateFashion.getATable(6,5));
        Assert.assertEquals(1,dateFashion.getATable(4,7));
    }
}