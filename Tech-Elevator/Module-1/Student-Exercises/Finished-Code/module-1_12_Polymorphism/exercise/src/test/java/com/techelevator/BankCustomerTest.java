package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

/**
 * BankCustomer
 */
public class BankCustomerTest {

    private static Class customer;
    private static Class creditCard;
    private static Class accountable;

    @Before
    public void classShouldExist() {
        try {
            customer = Class.forName("com.techelevator.BankCustomer");
        } catch (ClassNotFoundException e) {
            fail("com.techelevator.BankCustomer class does not exist");
        }

        try {
            creditCard = Class.forName("com.techelevator.CreditCardAccount");
        } catch (ClassNotFoundException e) {
            fail(e.getMessage());
        }

        try {
            accountable = Class.forName("com.techelevator.Accountable");
        } catch (ClassNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void shouldContainFieldName() {
        Field f = SafeReflection.getDeclaredField(customer, "name");
        assertNotNull("Field name does not exist", f);
        assertEquals("Field name should be of Type String", "java.lang.String", f.getType().getName());
        assertTrue("Field name should be private", Modifier.isPrivate(f.getModifiers()));
    }

    @Test
    public void shouldContainFieldAddress() {
        Field f = SafeReflection.getDeclaredField(customer, "address");
        assertNotNull("Field address does not exist", f);
        assertEquals("Field address should be of Type String", "java.lang.String", f.getType().getName());
        assertTrue("Field address should be private", Modifier.isPrivate(f.getModifiers()));
    }

    @Test
    public void shouldContainFieldPhoneNumber() {
        Field f = SafeReflection.getDeclaredField(customer, "phoneNumber");
        assertNotNull("Field phoneNumber does not exist", f);
        assertEquals("Field phoneNumber should be of Type String", "java.lang.String", f.getType().getName());
        assertTrue("Field phoneNumber should be private", Modifier.isPrivate(f.getModifiers()));
    }

    @Test
    public void shouldHaveNoArgsConstructor() {
        Constructor constructor = SafeReflection.getConstructor(customer);
        assertNotNull("BankCustomer should contain a no-args constructor.",constructor);
    }

    @Test
    public void testConstructorAndSetters() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object bankCustomer = constructor.newInstance();

        // setters
        Method setName = SafeReflection.getMethod(bankCustomer.getClass(), "setName", String.class);
        setName.invoke(bankCustomer,"TTEST");
        Method setAddress = SafeReflection.getMethod(bankCustomer.getClass(), "setAddress", String.class);
        setAddress.invoke(bankCustomer,"TEST");
        Method setPhoneNumber = SafeReflection.getMethod(bankCustomer.getClass(), "setPhoneNumber", String.class);
        setPhoneNumber.invoke(bankCustomer,"3329383394");

        // getters
        Method getName = SafeReflection.getMethod(bankCustomer.getClass(),"getName");
        assertEquals("TTEST", getName.invoke(bankCustomer));
        Method getAddress = SafeReflection.getMethod(bankCustomer.getClass(),"getAddress");
        assertEquals("TEST", getAddress.invoke(bankCustomer));
        Method getPhoneNumber = SafeReflection.getMethod(bankCustomer.getClass(),"getPhoneNumber");
        assertEquals("3329383394", getPhoneNumber.invoke(bankCustomer));
    }

    @Test
    public void testAddAccount() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object sut = constructor.newInstance();

        // assuming checking and savings accounts exist because they are part of the starting code for this exercise
        CheckingAccount one = new CheckingAccount("Bernie", "33232443");
        SavingsAccount two = new SavingsAccount("Bernie", "282939283");

        Constructor ccAccountConstructor = SafeReflection.getConstructor(creditCard, String.class, String.class);
        Object three = ccAccountConstructor.newInstance("Bernie","6011234398473348");

        try {
            Method addAccount = sut.getClass().getMethod("addAccount",accountable);
            addAccount.invoke(sut,one);
            addAccount.invoke(sut,two);
            addAccount.invoke(sut,three);

            Method getAccounts = sut.getClass().getMethod("getAccounts");
            Object[] accounts = (Object[]) getAccounts.invoke(sut);
            assertEquals(3, accounts.length);
            assertEquals(one, accounts[0]);
            assertEquals(two, accounts[1]);
            assertEquals(three, accounts[2]);
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsVipInOneAccount() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object sut = constructor.newInstance();

        // assuming checking and savings accounts exist because they are part of the starting code for this exercise
        CheckingAccount one = new CheckingAccount("Bernie", "33232443");
        SavingsAccount two = new SavingsAccount("Bernie", "282939283");

        Constructor ccAccountConstructor = SafeReflection.getConstructor(creditCard, String.class, String.class);
        Object three = ccAccountConstructor.newInstance("Bernie","6011234398473348");

        try {
            Method addAccount = sut.getClass().getMethod("addAccount",accountable);
            addAccount.invoke(sut,one);
            addAccount.invoke(sut,two);
            addAccount.invoke(sut,three);

            one.deposit(25000);
            Method isVip = sut.getClass().getMethod("isVip");
            assertTrue((Boolean) isVip.invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsVipInMultipleAccounts() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object sut = constructor.newInstance();

        // assuming checking and savings accounts exist because they are part of the starting code for this exercise
        CheckingAccount one = new CheckingAccount("Bernie", "33232443");
        SavingsAccount two = new SavingsAccount("Bernie", "282939283");

        Constructor ccAccountConstructor = SafeReflection.getConstructor(creditCard, String.class, String.class);
        Object three = ccAccountConstructor.newInstance("Bernie","6011234398473348");

        try {
            Method addAccount = sut.getClass().getMethod("addAccount",accountable);
            addAccount.invoke(sut,one);
            addAccount.invoke(sut,two);
            addAccount.invoke(sut,three);
            one.deposit(10000);
            two.deposit(15000);
            Method isVip = sut.getClass().getMethod("isVip");
            assertTrue((Boolean) isVip.invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsVipWithCreditDebt() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object sut = constructor.newInstance();

        // assuming checking and savings accounts exist because they are part of the starting code for this exercise
        CheckingAccount one = new CheckingAccount("Bernie", "33232443");
        SavingsAccount two = new SavingsAccount("Bernie", "282939283");

        Constructor ccAccountConstructor = SafeReflection.getConstructor(creditCard, String.class, String.class);
        Object three = ccAccountConstructor.newInstance("Bernie","6011234398473348");

        try {
            Method addAccount = sut.getClass().getMethod("addAccount",accountable);
            addAccount.invoke(sut,one);
            addAccount.invoke(sut,two);
            addAccount.invoke(sut,three);
            one.deposit(15000);
            two.deposit(15000);
            Method charge = three.getClass().getMethod("charge", int.class);
            charge.invoke(three,5000);
            Method isVip = sut.getClass().getMethod("isVip");
            assertTrue((Boolean) isVip.invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsNOTVip() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object sut = constructor.newInstance();
        CheckingAccount one = new CheckingAccount("Bernie", "33232443");
        SavingsAccount two = new SavingsAccount("Bernie", "282939283");
        Constructor ccAccountConstructor = SafeReflection.getConstructor(creditCard, String.class, String.class);
        Object three = ccAccountConstructor.newInstance("Bernie","6011234398473348");

        try {
            Method addAccount = sut.getClass().getMethod("addAccount",accountable);
            addAccount.invoke(sut,one);
            addAccount.invoke(sut,two);
            addAccount.invoke(sut,three);
            Method isVip = sut.getClass().getMethod("isVip");
            assertFalse((Boolean) isVip.invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsNOTVipAt24999() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object sut = constructor.newInstance();

        // assuming checking and savings accounts exist because they are part of the starting code for this exercise
        CheckingAccount one = new CheckingAccount("Bernie", "33232443");
        SavingsAccount two = new SavingsAccount("Bernie", "282939283");

        Constructor ccAccountConstructor = SafeReflection.getConstructor(creditCard, String.class, String.class);
        Object three = ccAccountConstructor.newInstance("Bernie","6011234398473348");

        try {
            Method addAccount = sut.getClass().getMethod("addAccount",accountable);
            addAccount.invoke(sut,one);
            addAccount.invoke(sut,two);
            addAccount.invoke(sut,three);

            one.deposit(24999);
            Method isVip = sut.getClass().getMethod("isVip");
            assertFalse((Boolean) isVip.invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsNOTVipWithCreditDebt() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(customer);
        Object sut = constructor.newInstance();

        // assuming checking and savings accounts exist because they are part of the starting code for this exercise
        CheckingAccount one = new CheckingAccount("Bernie", "33232443");
        SavingsAccount two = new SavingsAccount("Bernie", "282939283");

        Constructor ccAccountConstructor = SafeReflection.getConstructor(creditCard, String.class, String.class);
        Object three = ccAccountConstructor.newInstance("Bernie","6011234398473348");

        try {
            Method addAccount = sut.getClass().getMethod("addAccount",accountable);
            addAccount.invoke(sut,one);
            addAccount.invoke(sut,two);
            addAccount.invoke(sut,three);
            one.deposit(15000);
            two.deposit(15000);
            Method charge = three.getClass().getMethod("charge", int.class);
            charge.invoke(three,5001);
            Method isVip = sut.getClass().getMethod("isVip");
            assertFalse((Boolean) isVip.invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

}