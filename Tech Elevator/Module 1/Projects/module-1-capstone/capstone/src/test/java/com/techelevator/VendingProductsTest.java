package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingProductsTest extends TestCase {
    public VendingProducts vendingProducts = new VendingProducts();
    public Inventory inventory = new Inventory();


    public void testTestToString() {
        vendingProducts.setPrice(1.20);
        vendingProducts.setName("Potato Crisps");
        vendingProducts.setSlotId("A1");
        vendingProducts.setCategory("Chips");
        Assert.assertEquals("A1 | Potato Crisps | $1.20 | Chips | 5",vendingProducts.toString());
    }

    @Test
    public void testToStringCategory() {
        Assert.assertEquals("Crunch Crunch, Yum!",vendingProducts.toStringCategory("chip"));

        Assert.assertEquals("Chew Chew, Yum!",vendingProducts.toStringCategory("gum"));

        Assert.assertEquals("Munch Munch, Yum!",vendingProducts.toStringCategory("candy"));
    }
    @Test
    public void testGetTotal() {
        vendingProducts.setPrice(1.20);
        Assert.assertEquals(1.20,vendingProducts.getTotal(),.01);

    }
    @Test
    public void testIsInStock() {
        vendingProducts.setInventory(5);
        Assert.assertTrue(vendingProducts.isInStock());
    }
    @Test
    public void test_zero_inventory(){
        vendingProducts.setInventory(0);
        Assert.assertFalse(vendingProducts.isInStock());
    }

}