package com.techelevator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * RectangleWallTest
 */
public class RectangleWallTest {

    private static Class<?> rectangle;

    @BeforeClass
    public static void setup() {
        try {
            rectangle = Class.forName("com.techelevator.RectangleWall");
        } catch (ClassNotFoundException e) {
            fail("com.techelevator.RectangleWall class not found");
        }
    }

    @Test
    public void testCreateRectangleWall() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = rectangle.getConstructor(String.class,String.class,int.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 1, 2);
            assertNotNull(sut);
            assertEquals("TEST", sut.getClass().getMethod("getName").invoke(sut));
            assertEquals("TESTCOLOR", sut.getClass().getMethod("getColor").invoke(sut));
            assertEquals(1, sut.getClass().getMethod("getLength").invoke(sut));
            assertEquals(2, sut.getClass().getMethod("getHeight").invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsAWall() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = rectangle.getConstructor(String.class,String.class,int.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 1, 2);
            assertNotNull(sut);
            assertEquals("com.techelevator.Wall",sut.getClass().getSuperclass().getTypeName());
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetArea() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = rectangle.getConstructor(String.class,String.class,int.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 1, 3);
            assertEquals(3, sut.getClass().getMethod("getArea").invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetString() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = rectangle.getConstructor(String.class,String.class,int.class,int.class);
            Object sut = constructor.newInstance("TEST", "TESTCOLOR", 1, 3);
            assertEquals("TEST (1x3) rectangle", sut.getClass().getMethod("toString").invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

}