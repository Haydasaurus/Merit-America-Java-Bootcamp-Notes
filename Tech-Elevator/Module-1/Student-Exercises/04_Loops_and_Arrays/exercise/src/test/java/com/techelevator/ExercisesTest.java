package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	Exercises exercises = new Exercises();

	/*
	 firstLast6([1, 2, 6]) → true
	 firstLast6([6, 1, 2, 3]) → true
	 firstLast6([13, 6, 1, 2, 3]) → false
	 */
	@Test
	public void firstLast6() {
		assertEquals("Input: firstLast6(new int[]{1, 2, 6})", true, exercises.firstLast6(new int[] { 1, 2, 6 }));
		assertEquals("Input: firstLast6(new int[]{6, 1, 2, 3})", true, exercises.firstLast6(new int[] { 6, 1, 2, 3 }));
		assertEquals("Input: firstLast6(new int[]{13, 6, 1, 2, 3})", false,
				exercises.firstLast6(new int[] { 13, 6, 1, 2, 3 }));
	}

	/*
	 sameFirstLast([1, 2, 3]) → false
	 sameFirstLast([1, 2, 3, 1]) → true
	 sameFirstLast([1, 2, 1]) → true
	 */
	@Test
	public void sameFirstLast() {
		assertEquals("Input: sameFirstLast(new int[]{1, 2, 3})", false, exercises.sameFirstLast(new int[] { 1, 2, 3 }));
		assertEquals("Input: sameFirstLast(new int[]{1, 2, 3, 1})", true,
				exercises.sameFirstLast(new int[] { 1, 2, 3, 1 }));
		assertEquals("Input: sameFirstLast(new int[]{1, 2, 1})", true, exercises.sameFirstLast(new int[] { 1, 2, 1 }));
	}

	/*
	 makePi() → [3, 1, 4]
	 */
	@Test
	public void makePi() {
		assertArrayEquals("Input: makePi()", new int[] { 3, 1, 4 }, exercises.makePi());
	}

	/*
	 commonEnd([1, 2, 3], [7, 3]) → true
	 commonEnd([1, 2, 3], [7, 3, 2]) → false
	 commonEnd([1, 2, 3], [1, 3]) → true
	 */
	@Test
	public void commonEnd() {
		assertEquals("Input: commonEnd(new int[]{1, 2, 3}, new int[]{7, 3})", true,
				exercises.commonEnd(new int[] { 1, 2, 3 }, new int[] { 7, 3 }));
		assertEquals("Input: commonEnd(new int[]{1, 2, 3}, new int[]{7, 3, 2})", false,
				exercises.commonEnd(new int[] { 1, 2, 3 }, new int[] { 7, 3, 2 }));
		assertEquals("Input: commonEnd(new int[]{1, 2, 3}, new int[]{1, 3})", true,
				exercises.commonEnd(new int[] { 1, 2, 3 }, new int[] { 1, 3 }));
	}

	/*
	 sum3([1, 2, 3]) → 6
	 sum3([5, 11, 2]) → 18
	 sum3([7, 0, 0]) → 7
	 */
	@Test
	public void sum3() {
		assertEquals("Input: sum3(new int[]{1, 2, 3})", 6, exercises.sum3(new int[] { 1, 2, 3 }));
		assertEquals("Input: sum3(new int[]{5, 11, 2})", 18, exercises.sum3(new int[] { 5, 11, 2 }));
		assertEquals("Input: sum3(new int[]{7, 0, 0})", 7, exercises.sum3(new int[] { 7, 0, 0 }));
	}

	/*
	 rotateLeft3([1, 2, 3]) → [2, 3, 1]
	 rotateLeft3([5, 11, 9]) → [11, 9, 5]
	 rotateLeft3([7, 0, 0]) → [0, 0, 7]
	 */
	@Test
	public void rotateLeft3() {
		assertArrayEquals("Input: rotateLeft3(new int[]{1, 2, 3})", new int[] { 2, 3, 1 },
				exercises.rotateLeft3(new int[] { 1, 2, 3 }));
		assertArrayEquals("Input: rotateLeft3(new int[]{5, 11, 9})", new int[] { 11, 9, 5 },
				exercises.rotateLeft3(new int[] { 5, 11, 9 }));
		assertArrayEquals("Input: rotateLeft3(new int[]{7, 0, 0})", new int[] { 0, 0, 7 },
				exercises.rotateLeft3(new int[] { 7, 0, 0 }));
	}

	/*
	 reverse3([1, 2, 3]) → [3, 2, 1]
	 reverse3([5, 11, 9]) → [9, 11, 5]
	 reverse3([7, 0, 0]) → [0, 0, 7]
	 */
	@Test
	public void reverse3() {
		assertArrayEquals("Input: reverse3(new int[]{1, 2, 3})", new int[] { 3, 2, 1 },
				exercises.reverse3(new int[] { 1, 2, 3 }));
		assertArrayEquals("Input: reverse3(new int[]{5, 11, 9})", new int[] { 9, 11, 5 },
				exercises.reverse3(new int[] { 5, 11, 9 }));
		assertArrayEquals("Input: reverse3(new int[]{7, 0, 0})", new int[] { 0, 0, 7 },
				exercises.reverse3(new int[] { 7, 0, 0 }));
	}

	/*
	 maxEnd3([1, 2, 3]) → [3, 3, 3]
	 maxEnd3([11, 5, 9]) → [11, 11, 11]
	 maxEnd3([2, 11, 3]) → [3, 3, 3]
	 */
	@Test
	public void maxEnd3() {
		assertArrayEquals("Input: maxEnd3(new int[]{1, 2, 3})", new int[] { 3, 3, 3 },
				exercises.maxEnd3(new int[] { 1, 2, 3 }));
		assertArrayEquals("Input: maxEnd3(new int[]{11, 5, 9})", new int[] { 11, 11, 11 },
				exercises.maxEnd3(new int[] { 11, 5, 9 }));
		assertArrayEquals("Input: maxEnd3(new int[]{2, 11, 3})", new int[] { 3, 3, 3 },
				exercises.maxEnd3(new int[] { 2, 11, 3 }));
	}

	/*
	 sum2([1, 2, 3]) → 3
	 sum2([1, 1]) → 2
	 sum2([1, 1, 1, 1]) → 2
	 */
	@Test
	public void sum2() {
		assertEquals("Input: sum2(new int[]{1, 2, 3})", 3, exercises.sum2(new int[] { 1, 2, 3 }));
		assertEquals("Input: sum2(new int[]{1, 1})", 2, exercises.sum2(new int[] { 1, 1 }));
		assertEquals("Input: sum2(new int[]{1, 1, 1, 1})", 2, exercises.sum2(new int[] { 1, 1, 1, 1 }));

		assertEquals("Input: sum2(new int[]{5})", 5, exercises.sum2(new int[] { 5 }));
		assertEquals("Input: sum2(new int[]{})", 0, exercises.sum2(new int[] { }));
	}

	/*
	 middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
	 middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
	 middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
	 */
	@Test
	public void middleWay() {
		assertArrayEquals("Input: middleWay(new int[]{1, 2, 3}, new int[]{4, 5, 6})", new int[] { 2, 5 },
				exercises.middleWay(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }));
		assertArrayEquals("Input: middleWay(new int[]{7, 7, 7}, new int[]{3, 8, 0})", new int[] { 7, 8 },
				exercises.middleWay(new int[] { 7, 7, 7 }, new int[] { 3, 8, 0 }));
		assertArrayEquals("Input: middleWay(new int[]{5, 2, 9}, new int[]{1, 4, 5})", new int[] { 2, 4 },
				exercises.middleWay(new int[] { 5, 2, 9 }, new int[] { 1, 4, 5 }));
	}

	/*
	 countEvens([2, 1, 2, 3, 4]) → 3
	 countEvens([2, 2, 0]) → 3
	 countEvens([1, 3, 5]) → 0
	 */
	@Test
	public void countEvens() {
		assertEquals("Input: countEvens(new int[]{2, 1, 2, 3, 4})", 3,
				exercises.countEvens(new int[] { 2, 1, 2, 3, 4 }));
		assertEquals("Input: countEvens(new int[]{2, 2, 0})", 3, exercises.countEvens(new int[] { 2, 2, 0 }));
		assertEquals("Input: countEvens(new int[]{1, 3, 5})", 0, exercises.countEvens(new int[] { 1, 3, 5 }));
	}

	/*
	 sum13([1, 2, 2, 1]) → 6
	 sum13([1, 1]) → 2
	 sum13([1, 2, 2, 1, 13]) → 6
	 sum13([1, 2, 2, 1, 13, 3]) → 6
	 sum13([1, 2, 2, 1, 13, 3, 4]) → 10
	 */
	@Test
	public void sum13() {
		assertEquals("Input: sum13(new int[]{1, 2, 2, 1})", 6, exercises.sum13(new int[] { 1, 2, 2, 1 }));
		assertEquals("Input: sum13(new int[]{1, 1})", 2, exercises.sum13(new int[] { 1, 1 }));
		assertEquals("Input: sum13(new int[]{1, 2, 2, 1, 13})", 6, exercises.sum13(new int[] { 1, 2, 2, 1, 13 }));
		assertEquals("Input: sum13(new int[]{1, 2, 2, 1, 13, 3})", 6, exercises.sum13(new int[] { 1, 2, 2, 1, 13, 3 }));
		assertEquals("Input: sum13(new int[]{1, 2, 2, 1, 13, 3, 4})", 10, exercises.sum13(new int[] { 1, 2, 2, 1, 13, 3, 4 }));
		assertEquals("Input: sum13(new int[]{1, 13, 2, 3, 13})", 4, exercises.sum13(new int[] { 1, 13, 2, 3, 13 }));
		assertEquals("Input: sum13(new int[]{1, 13, 2, 3, 13, 4})", 4, exercises.sum13(new int[] { 1, 13, 2, 3, 13, 4 }));
		assertEquals("Input: sum13(new int[]{1, 13, 2, 3, 13, 4, 5})", 9, exercises.sum13(new int[] { 1, 13, 2, 3, 13, 4, 5 }));
		assertEquals("Input: sum13(new int[]{13, 1, 13})", 0, exercises.sum13(new int[] { 13, 1, 13  }));
		assertEquals("Input: sum13(new int[]{13, 1, 13, 2})", 0, exercises.sum13(new int[] { 13, 1, 13, 2 }));
		assertEquals("Input: sum13(new int[]{13, 1, 13, 2, 3})", 3, exercises.sum13(new int[] { 13, 1, 13, 2, 3 }));
		assertEquals("Input: sum13(new int[]{13, 13, 13})", 0, exercises.sum13(new int[] { 13, 13, 13 }));
		assertEquals("Input: sum13(new int[]{13, 13, 13, 1})", 0, exercises.sum13(new int[] { 13, 13, 13, 1 }));
		assertEquals("Input: sum13(new int[]{13, 13, 13, 1, 2, 3})", 5, exercises.sum13(new int[] { 13, 13, 13, 1, 2, 3 }));
	}

	/*
	 has22([1, 2, 2]) → true
	 has22([1, 2, 1, 2]) → false
	 has22([2, 1, 2]) → false
	 */
	@Test
	public void has22() {
		assertEquals("Input: has22(new int[]{1, 2, 2})", true, exercises.has22(new int[] { 1, 2, 2 }));
		assertEquals("Input: has22(new int[]{1, 2, 1, 2})", false, exercises.has22(new int[] { 1, 2, 1, 2 }));
		assertEquals("Input: has22(new int[]{2, 1, 2})", false, exercises.has22(new int[] { 2, 1, 2 }));

		assertEquals("Input: has22(new int[]{1, 2, 2, 3})", true, exercises.has22(new int[] { 1, 2, 2, 3 }));
		assertEquals("Input: has22(new int[]{2, 2, 3})", true, exercises.has22(new int[] { 2, 2, 3 }));

		assertEquals("Input: has22(new int[]{2, 2, 2})", true, exercises.has22(new int[] { 2, 2, 2}));
		assertEquals("Input: has22(new int[]{1, 2, 3, 4})", false, exercises.has22(new int[] { 1, 2, 3, 4 }));
		assertEquals("Input: has22(new int[]{3, 4, 5})", false, exercises.has22(new int[] { 3, 4, 5 }));
	}

	/*
	 lucky13([0, 2, 4]) → true
	 lucky13([1, 2, 3]) → false
	 lucky13([1, 2, 4]) → false
	 */
	@Test
	public void lucky13() {
		assertEquals("Input: lucky13(new int[]{0, 2, 4})", true, exercises.lucky13(new int[] { 0, 2, 4 }));
		assertEquals("Input: lucky13(new int[]{1, 2, 3})", false, exercises.lucky13(new int[] { 1, 2, 3 }));
		assertEquals("Input: lucky13(new int[]{1, 2, 4})", false, exercises.lucky13(new int[] { 1, 2, 4 }));
		assertEquals("Input: lucky13(new int[]{5, 2, 3})", false, exercises.lucky13(new int[] { 5, 2, 3 }));

		assertEquals("Input: lucky13(new int[]{2, 1, 0})", false, exercises.lucky13(new int[] { 2, 1, 0 }));
		assertEquals("Input: lucky13(new int[]{2, 3, 0})", false, exercises.lucky13(new int[] { 2, 3, 0 }));
		assertEquals("Input: lucky13(new int[]{2, 4, 1})", false, exercises.lucky13(new int[] { 2, 4, 1 }));
		assertEquals("Input: lucky13(new int[]{3, 0, 2})", false, exercises.lucky13(new int[] { 3, 0, 2 }));
		assertEquals("Input: lucky13(new int[]{0, 3, 4})", false, exercises.lucky13(new int[] { 0, 3, 4 }));
	}

	/*
	 sum28([2, 3, 2, 2, 4, 2]) → true
	 sum28([2, 3, 2, 2, 4, 2, 2]) → false
	 sum28([1, 2, 3, 4]) → false
	 */
	@Test
	public void sum28() {
		assertEquals("Input: sum28(new int[]{2, 3, 2, 2, 4, 2})", true,
				exercises.sum28(new int[] { 2, 3, 2, 2, 4, 2 }));
		assertEquals("Input: sum28(new int[]{2, 3, 2, 2, 4, 2, 2})", false,
				exercises.sum28(new int[] { 2, 3, 2, 2, 4, 2, 2 }));
		assertEquals("Input: sum28(new int[]{1, 2, 3, 4})", false, exercises.sum28(new int[] { 1, 2, 3, 4 }));
	}

}
