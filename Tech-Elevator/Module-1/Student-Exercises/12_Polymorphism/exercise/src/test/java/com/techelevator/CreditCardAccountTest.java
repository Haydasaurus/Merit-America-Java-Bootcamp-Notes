package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

/**
 * CreditCardAccountTest
 */
public class CreditCardAccountTest {

    private static Class creditCard;

    @Before
    public void classShouldExist() {
        try {
            creditCard = Class.forName("com.techelevator.CreditCardAccount");
        } catch (ClassNotFoundException e) {
            fail("com.techelevator.CreditCardAccount class does not exist");
        }
    }

    @Test
    public void testConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(creditCard,String.class,String.class);
        assertNotNull("CreditCardAccount should contain a 2 argument constructor that sets account holder name and number", constructor);

        Object sut = constructor.newInstance("TEST","6011222233334444");

        Method getAccountHolder = sut.getClass().getMethod("getAccountHolder");
        assertEquals("TEST", getAccountHolder.invoke(sut));

        Method getAccountNumber = sut.getClass().getMethod("getAccountNumber");
        assertEquals("6011222233334444", getAccountNumber.invoke(sut));
    }

    @Test
    public void testPay() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(creditCard,String.class,String.class);
        Object sut = constructor.newInstance("null","null");

        Method pay = sut.getClass().getMethod("pay", int.class);
        pay.invoke(sut, 25);
        Method getDebt = sut.getClass().getMethod("getDebt");
        assertEquals(-25, getDebt.invoke(sut));
    }

    @Test
    public void testCharge() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(creditCard,String.class,String.class);
        Object sut = constructor.newInstance("null","null");

        Method charge = sut.getClass().getMethod("charge", int.class);
        charge.invoke(sut, 25);
        Method getDebt = sut.getClass().getMethod("getDebt");
        assertEquals(25, getDebt.invoke(sut));
    }

    @Test
    public void testAmount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(creditCard,String.class,String.class);
        Object sut = constructor.newInstance("null","null");

        Method charge = sut.getClass().getMethod("charge", int.class);
        charge.invoke(sut, 500);

        Method getDebt = sut.getClass().getMethod("getDebt");
        assertEquals(500, getDebt.invoke(sut));

        Method getBalance = sut.getClass().getMethod("getBalance");
        assertEquals(-500, getBalance.invoke(sut));
    }
}