package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

public class MoneyTest extends TestCase {
    public Money money = new Money();
    VendingProducts vendingProducts = new VendingProducts();
    ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void testGetWallet() {
        double customerMoney = 3;
        Money.setWallet(Collections.singletonList(customerMoney));
        Assert.assertEquals(3.00,money.getCurrentMoney(),.01);
    }

    @Test
    public void testReturnChange() {
        Assert.assertEquals("Change returned:40 Quarters, 0 Dimes, and 0 Nickles.",money.returnChange(10));
        Assert.assertEquals("Change returned:34 Quarters, 1 Dimes, and 1 Nickles.",money.returnChange(8.65));
    }
    @Test
    public void test_return_change_with_zero_money(){
        Assert.assertEquals("Change returned:0 Quarters, 0 Dimes, and 0 Nickles.",money.returnChange(0));
    }
}