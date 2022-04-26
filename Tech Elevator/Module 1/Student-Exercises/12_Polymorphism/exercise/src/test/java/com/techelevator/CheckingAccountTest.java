package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

    private static Class chkAccount;

    @Before
    public void checkingAccountClassShouldExist() {
        try {
            chkAccount = Class.forName("com.techelevator.CheckingAccount");
        } catch (ClassNotFoundException ex) {
            fail("com.techelevator.CheckingAccount class does not exist");
        }
    }

    @Test
    public void transferTests() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class, String.class, int.class);
        BankAccount source = (BankAccount) constructor.newInstance("","",50);
        BankAccount destination = (BankAccount) constructor.newInstance("","",0);

        Method transferTo = source.getClass().getMethod("transferTo", BankAccount.class, int.class);
        int newSourceBalance = (int) transferTo.invoke(source,destination,24);

        assertEquals(26, newSourceBalance);
        assertEquals(24, destination.getBalance());
        assertEquals(26, source.getBalance());
    }

}


