package com.techelevator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * SquareWallTest
 */
public class SquareWallTest {

    private static Class<?> square;

    @BeforeClass
    public static void setup() {
        try {
            square = Class.forName("com.techelevator.SquareWall");
        } catch (ClassNotFoundException e) {
            fail("com.techelevator.SquareWall class not found");
        }
    }

    @Test
    public void testIsAWall() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = square.getConstructor(String.class,String.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 1);
            assertNotNull(sut);

            // walk the class hierarchy looking for Wall
            List<String> superClasses = new ArrayList<>();
            Class<?> clazz = sut.getClass();
            // Object has no superClass
            while(clazz != null && clazz.getName() != "java.lang.Object") {
                superClasses.add(clazz.getSuperclass().getTypeName());
                clazz = clazz.getSuperclass();
            }

            assertTrue(superClasses.contains("com.techelevator.Wall"));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsARectangleWall() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = square.getConstructor(String.class,String.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 1);
            assertNotNull(sut);
            assertEquals("com.techelevator.RectangleWall",sut.getClass().getSuperclass().getTypeName());
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetArea() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = square.getConstructor(String.class,String.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 3);
            assertEquals(9, sut.getClass().getMethod("getArea").invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetString() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = square.getConstructor(String.class,String.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 3);
            assertEquals("TEST (3x3) square", sut.getClass().getMethod("toString").invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }
}