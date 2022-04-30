package com.techelevator;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

public class WallTest {

    private static Class<?> wall;

    @BeforeClass
    public static void setup() {
        try {
            wall = Class.forName("com.techelevator.Wall");
        } catch (ClassNotFoundException e) {
            fail("com.techelevator.Wall class not found");
        }
    }

    @Test
    public void shouldBeAbstractClass() {
        assertTrue("Wall should be an abstract class", Modifier.isAbstract(wall.getModifiers()));
    }

    @Test
    public void shouldHaveFieldName() {
        try {
            Field name = wall.getDeclaredField("name");
            // should be a private field
            assertTrue(Modifier.isPrivate(name.getModifiers()));
            // should be type String
            assertEquals("java.lang.String", name.getType().getTypeName());
            // should have a getter
            assertTrue(hasGetter(name));
        } catch (NoSuchFieldException e) {
            fail("Wall class must contain field: name");
        }
    }

    @Test
    public void shouldHaveFieldColor() {
        try {
            Field color = wall.getDeclaredField("color");
            // should be a private field
            assertTrue(Modifier.isPrivate(color.getModifiers()));
            // should be type String
            assertEquals("java.lang.String", color.getType().getTypeName());
            // should have a getter
            assertTrue(hasGetter(color));
        } catch (NoSuchFieldException e) {
            fail("Wall class must contain field: color");
        }
    }

    @Test
    public void shouldHaveTwoArgConstructor() {
        try {
            wall.getConstructor(String.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("Wall should have a two arg constructor: public Wall(String name, String color)");
        }
    }

    @Test
    public void shouldHaveAbstractMethodGetArea() {
        try {
            Method getArea = wall.getMethod("getArea");
            assertTrue(Modifier.isPublic(getArea.getModifiers()));
            assertTrue(Modifier.isAbstract(getArea.getModifiers()));
            assertEquals(int.class, getArea.getReturnType());
        } catch (NoSuchMethodException e) {
            fail("Wall should have an abstract method getArea with a return type of int");
        }
    }

    private boolean hasGetter(Field field) {
        return hasGetterOrSetter(field, "get");
    }

    private boolean hasGetterOrSetter(Field field, String prefix) {
        Optional<Method> getterOrSetter = Arrays.stream(wall.getMethods())
                .filter(f -> f.getName()
                        .equals(prefix + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1)))
                .findFirst();
        return getterOrSetter.isPresent();
    }
}
