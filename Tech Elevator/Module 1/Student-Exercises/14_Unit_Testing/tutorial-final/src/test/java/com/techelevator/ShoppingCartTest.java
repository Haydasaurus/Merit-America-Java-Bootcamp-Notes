package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void createAndFillCart() {
        // Create a shopping cart and add both taxable and non-taxable items to it.
        this.cart = new ShoppingCart(0.10);     // 10% tax rate

        // Taxable $10 plus $1 tax
        cart.add( new Book("Dynamics of Software Development", "Jim McCarthy", 10.00));
        // Taxable $20 plus $2 tax
        cart.add( new Movie("Free Guy", "PG-13", 115, 20.00));
        // Not taxable $10
        cart.add( new Coffee("Jumbo", "Bold", new String[]{"cream"}, 10.00));
    }

    @Test
    public void subtotal_should_equal_sum_of_all_items() {
        // Arrange - the @Before method creates a cart before every test

        // Act - get the subtotal
        double subtotal = cart.getSubtotalPrice();

        // Assert - Make sure value is correct
        Assert.assertEquals(40.00, subtotal, 0.00);
    }

    @Test
    public void tax_should_equal_tax_on_taxable_items() {
        // Arrange - the @Before method creates a cart before every test

        // Act - get the tax
        double tax = cart.getTax();

        // Assert - Make sure value is correct
        Assert.assertEquals(3.00, tax, 0.00);
    }

    @Test
    public void total_should_equal_sum_of_items_plus_tax() {
        // Arrange - the @Before method creates a cart before every test

        // Act - get the total
        double total = cart.getTotalPrice();

        // Assert - Make sure value is correct
        Assert.assertEquals(43.00, total, 0.00);
    }
}
