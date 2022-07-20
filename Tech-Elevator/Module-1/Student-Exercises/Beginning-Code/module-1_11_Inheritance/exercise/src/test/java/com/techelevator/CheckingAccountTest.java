package com.techelevator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CheckingAccountTest {

    private static Class chkAccount;

    @BeforeClass
    public static void checkingAccountClassShouldExist() {
        try {
            chkAccount = Class.forName("com.techelevator.CheckingAccount");
        } catch (Exception e) {
            fail("com.techelevator.CheckingAccount class does not exist");
        }
    }

    @Test
    public void checkingAccountShouldExtendBankAccount() {
        Class superclass = chkAccount.getSuperclass();
        assertEquals("Checking Account should inherit from Bank Account",superclass.getName(),"com.techelevator.BankAccount");
    }

    @Test
    public void shouldHaveTwoArgumentConstructor() {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class, String.class);
        assertNotNull("com.techelevator.CheckingAccount should contain a 2 argument constructor that calls the matching BankAccount constructor.",constructor);
    }

    @Test
    public void shouldHaveThreeArgumentConstructor() {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class, String.class, int.class);
        assertNotNull("com.techelevator.CheckingAccount should contain a 3 argument constructor that calls the matching BankAccount constructor.",constructor);
    }

    @Test
    public void withdrawNegativeWithFeeBalance_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,int.class);
        Object checkingAccount = constructor.newInstance("", "", -1);

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        int newBalance = (int) withdraw.invoke(checkingAccount, 1);
        assertEquals(-12, newBalance);
        assertEquals(-12, getBalance.invoke(checkingAccount));
    }

    @Test
    public void withdrawPositiveWithFee_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,int.class);
        Object checkingAccount = constructor.newInstance("", "", -1);

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        int newBalance = (int) withdraw.invoke(checkingAccount, 2);
        assertEquals(-13, newBalance);
        assertEquals(-13, getBalance.invoke(checkingAccount));
    }

    @Test
    public void withdrawNegativeBalanceBelow100_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,int.class);
        Object checkingAccount = constructor.newInstance("", "", -100);

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        int newBalance = (int) withdraw.invoke(checkingAccount, 2);
        assertEquals(-100, newBalance);
        assertEquals(-100, getBalance.invoke(checkingAccount));
    }

    @Test
    public void withdrawPositiveBalance_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,int.class);
        Object checkingAccount = constructor.newInstance("", "", 10);

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", int.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        int newBalance = (int) withdraw.invoke(checkingAccount, 5);
        assertEquals(5, newBalance);
        assertEquals(5, getBalance.invoke(checkingAccount));
    }
}
