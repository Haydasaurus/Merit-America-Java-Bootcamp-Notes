package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.techelevator.FruitTree;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FruitTreeTest {

	@Before
	public void fruitTreeRequiredMembers() {
		Class klass = FruitTree.class;

		Constructor<FruitTree> constructor = SafeReflection.getConstructor(klass, String.class, Integer.TYPE);
		assertTrue("You do not have the required constructor(String, int)", constructor != null);

		Method method = SafeReflection.getMethod(klass, "getTypeOfFruit");
		assertTrue("FruitTree class needs the getTypeOfFruit() method.", method != null);
		assertTrue("getTypeOfFruit() method needs to return type: String", method.getReturnType() == String.class);

		method = SafeReflection.getMethod(klass, "setTypeOfFruit", String.class);
		assertTrue("FruitTree class should not have a getTypeOfFruit(String) method", method == null);

		method = SafeReflection.getMethod(klass, "getPiecesOfFruitLeft");
		assertTrue("FruitTree class needs the getPiecesOfFruitLeft() method.", method != null);
		assertTrue("getPiecesOfFruitLeft() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setPiecesOfFruitLeft", Integer.TYPE);
		assertTrue("FruitTree class should not have a setPiecesOfFruitLeft(int) method", method == null);

		method = SafeReflection.getMethod(klass, "pickFruit", Integer.TYPE);
		assertTrue("FruitTree class needs the pickFruit(int) method.", method != null);
		assertTrue("pickFruit(int) method needs to return type: boolean", method.getReturnType() == Boolean.TYPE);
	}

	@Test
	public void fruitTreeConstructorTest() {
		Class klass = FruitTree.class;

		Constructor<FruitTree> constructor = SafeReflection.getConstructor(klass, String.class, Integer.TYPE);
		assertTrue("You do not have the required constructor(String, int)", constructor != null);
		try {
			FruitTree fruitTree = constructor.newInstance("Apple", 97);
			Method getPiecesOfFruitLeft = SafeReflection.getMethod(klass, "getPiecesOfFruitLeft");
			Method getTypeOfFruit = SafeReflection.getMethod(klass, "getTypeOfFruit");

			assertTrue("Passed Apple into constructor and expected typeOfFruit equal Apple",
					"Apple".equals((String) getTypeOfFruit.invoke(fruitTree)));
			assertTrue("Passed 97 into constructor and expected piecesOfFruitLeft equal 97",
					97 == (int) getPiecesOfFruitLeft.invoke(fruitTree));
		} catch (Exception e) {
			fail("Failed to instantiate FruitTree");
		}
	}

	@Test
	public void FruitTree_PickFruitTests() {
		Class klass = FruitTree.class;

		Constructor<FruitTree> constructor = SafeReflection.getConstructor(klass, String.class, Integer.TYPE);
		assertTrue("You do not have the required constructor(String, int)", constructor != null);
		try {
			FruitTree fruitTree = constructor.newInstance("Apple", 3);
			Method pickFruit = SafeReflection.getMethod(klass, "pickFruit", Integer.TYPE);
			Method getPiecesOfFruitLeft = SafeReflection.getMethod(klass, "getPiecesOfFruitLeft");

			assertTrue("pickFruit(int) should return TRUE when pieces remain",
					(boolean) pickFruit.invoke(fruitTree, new Object[] { 2 }));
			assertTrue("Tree started with 3 pieces of fruit. 2 were picked, 1 should be remaining",
					1 == (int) getPiecesOfFruitLeft.invoke(fruitTree));

			assertTrue("pickFruit(int) should return TRUE when pieces remain",
					(boolean) pickFruit.invoke(fruitTree, new Object[] { 1 }));
			assertTrue("Tree started with 1 piece of fruit. 1 were picked, 0 should be remaining",
					0 == (int) getPiecesOfFruitLeft.invoke(fruitTree));

			assertFalse("pickFruit(int) should return FALSE when not enough remaining pieces of fruit.",
					(boolean) pickFruit.invoke(fruitTree, new Object[] { 1 }));
			assertTrue("Tree had 0 pieces of fruit. 1 was not picked, 0 should be remaining",
					0 == (int) getPiecesOfFruitLeft.invoke(fruitTree));
		} catch (Exception e) {
			fail("Failed to instantiate FruitTree");
		}
	}

}
