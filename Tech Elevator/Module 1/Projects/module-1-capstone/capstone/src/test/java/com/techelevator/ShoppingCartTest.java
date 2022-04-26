package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

public class ShoppingCartTest extends TestCase {

    public ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void test_multiple_prices(){
        shoppingCart.addItems(new VendingProducts("B3","Potato Crisps",1.00,"chip",4));
        shoppingCart.addItems(new VendingProducts("A1","Wolf Cola",3.20,"drink",4));
        Assert.assertEquals(4.20,shoppingCart.getPrice(),.01);
    }

    @Test
    public void test_potato_crisp_price() {
        shoppingCart.addItems(new VendingProducts("A1","Potato Crisps",2.10,"chip",4));
        Assert.assertEquals(2.10,shoppingCart.getPrice(),.01);
    }
    @Test
    public void test_zero_dollars(){
        shoppingCart.addItems(new VendingProducts("d5","Wolf Cola",0.00,"chip",4));
        Assert.assertEquals(0.00,shoppingCart.getPrice(),.01);
    }
}