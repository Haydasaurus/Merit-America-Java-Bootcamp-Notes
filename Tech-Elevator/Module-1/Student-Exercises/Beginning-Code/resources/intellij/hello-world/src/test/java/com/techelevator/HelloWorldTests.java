package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

public class HelloWorldTests {

    @Test
    public void twoPlusTwoEqualsFour() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void sevenDividedByTwoIsThree() {
        int result = 7 / 2;
        assertEquals(3, result);
    }

    @Test
    public void sevenDividedByTwoIsThreeAndOneHalf() {
        double result = 7.0 / 2;
        assertEquals(3.5, result, 0.01);
    }

}
