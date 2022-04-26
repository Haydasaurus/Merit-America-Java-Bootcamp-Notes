package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	private Exercises exercises = new Exercises();

	/*
	 sleepIn(false, false) → true
	 sleepIn(true, false) → false
	 sleepIn(false, true) → true
	 */
	@Test
	public void sleepIn() {
		assertEquals("Input: sleepIn(false, false)", true, exercises.sleepIn(false, false));
		assertEquals("Input: sleepIn(true, false)", false, exercises.sleepIn(true, false));
		assertEquals("Input: sleepIn(false, true)", true, exercises.sleepIn(false, true));
		assertEquals("Input: sleepIn(true, true)", true, exercises.sleepIn(true, true));
	}

	/*
	 monkeyTrouble(true, true) → true
	 monkeyTrouble(false, false) → true
	 monkeyTrouble(true, false) → false
	 */
	@Test
	public void monkeyTrouble() {
		assertEquals("Input: monkeyTrouble(true, true)", true, exercises.monkeyTrouble(true, true));
		assertEquals("Input: monkeyTrouble(false, false)", true, exercises.monkeyTrouble(false, false));
		assertEquals("Input: monkeyTrouble(true, false)", false, exercises.monkeyTrouble(true, false));
		assertEquals("Input: monkeyTrouble(false, true)", false, exercises.monkeyTrouble(false, true));
	}

	/*
	 sumDouble(1, 2) → 3
	 sumDouble(3, 2) → 5
	 sumDouble(2, 2) → 8
	 */
	@Test
	public void sumDouble() {
		assertEquals("Input: sumDouble(1, 2)", 3, exercises.sumDouble(1, 2));
		assertEquals("Input: sumDouble(3, 2)", 5, exercises.sumDouble(3, 2));
		assertEquals("Input: sumDouble(2, 2)", 8, exercises.sumDouble(2, 2));
		assertEquals("Input: sumDouble(-1, 0)", -1, exercises.sumDouble(-1, 0));
		assertEquals("Input: sumDouble(3, 3)", 12, exercises.sumDouble(3, 3));
		assertEquals("Input: sumDouble(0, 0)", 0, exercises.sumDouble(0, 0));
		assertEquals("Input: sumDouble(0, 1)", 1, exercises.sumDouble(0, 1));
		assertEquals("Input: sumDouble(3, 4)", 7, exercises.sumDouble(3, 4));
	}

	/*
	 diff21(19) → 2
	 diff21(10) → 11
	 diff21(21) → 0
	 diff21(22) → 2
	 diff21(-10) → 31
	 */
	@Test
	public void diff21() {
		assertEquals("Input: diff21(19)", 2, exercises.diff21(19));
		assertEquals("Input: diff21(10)", 11, exercises.diff21(10));
		assertEquals("Input: diff21(21)", 0, exercises.diff21(21));
		assertEquals("Input: diff21(22)", 2, exercises.diff21(22));
		assertEquals("Input: diff21(25)", 8, exercises.diff21(25));
		assertEquals("Input: diff21(30)", 18, exercises.diff21(30));
		assertEquals("Input: diff21(0)", 21, exercises.diff21(0));
		assertEquals("Input: diff21(1)", 20, exercises.diff21(1));
		assertEquals("Input: diff21(2)", 19, exercises.diff21(2));
		assertEquals("Input: diff21(-1)", 22, exercises.diff21(-1));
		assertEquals("Input: diff21(-2)", 23, exercises.diff21(-2));
		assertEquals("Input: diff21(50)", 58, exercises.diff21(50));
	}

	/*
	 parrotTrouble(true, 6) → true
	 parrotTrouble(true, 7) → false
	 parrotTrouble(false, 6) → false
	 */
	@Test
	public void parrotTrouble() {
		assertEquals("Input: parrotTrouble(true, 6)", true, exercises.parrotTrouble(true, 6));
		assertEquals("Input: parrotTrouble(true, 7)", false, exercises.parrotTrouble(true, 7));
		assertEquals("Input: parrotTrouble(false, 6)", false, exercises.parrotTrouble(false, 6));
		assertEquals("Input: parrotTrouble(true, 21)", true, exercises.parrotTrouble(true, 21));
		assertEquals("Input: parrotTrouble(false, 21)", false, exercises.parrotTrouble(false, 21));
		assertEquals("Input: parrotTrouble(false, 20)", false, exercises.parrotTrouble(false, 20));
		assertEquals("Input: parrotTrouble(true, 23)", true, exercises.parrotTrouble(true, 23));
		assertEquals("Input: parrotTrouble(false, 23)", false, exercises.parrotTrouble(false, 23));
		assertEquals("Input: parrotTrouble(true, 20)", false, exercises.parrotTrouble(true, 20));
		assertEquals("Input: parrotTrouble(false, 12)", false, exercises.parrotTrouble(false, 12));
	}

	/*
	 makes10(9, 10) → true
	 makes10(9, 9) → false
	 makes10(1, 9) → true
	 */
	@Test
	public void makes10() {
		assertEquals("Input: makes10(9, 10)", true, exercises.makes10(9, 10));
		assertEquals("Input: makes10(9, 9)", false, exercises.makes10(9, 9));
		assertEquals("Input: makes10(1, 9)", true, exercises.makes10(1, 9));
		assertEquals("Input: makes10(10, 1)", true, exercises.makes10(10, 1));
		assertEquals("Input: makes10(10, 10)", true, exercises.makes10(10, 10));
		assertEquals("Input: makes10(8, 2)", true, exercises.makes10(8, 2));
		assertEquals("Input: makes10(8, 3)", false, exercises.makes10(8, 3));
		assertEquals("Input: makes10(10, 42)", true, exercises.makes10(10, 42));
		assertEquals("Input: makes10(12, -2)", true, exercises.makes10(12, -2));
	}

	/*
	 posNeg(1, -1, false) → true
	 posNeg(-1, 1, false) → true
	 posNeg(-4, -5, true) → true
	 */
	@Test
	public void posNeg() {
		assertEquals("Input: posNeg(1, -1, false)", true, exercises.posNeg(1, -1, false));
		assertEquals("Input: posNeg(1, -1, true)", false, exercises.posNeg(1, -1, true));
		assertEquals("Input: posNeg(-1, 1, false)", true, exercises.posNeg(-1, 1, false));
		assertEquals("Input: posNeg(-1, 1, true)", false, exercises.posNeg(-1, 1, true));
		assertEquals("Input: posNeg(-4, -5, true)", true, exercises.posNeg(-4, -5, true));
		assertEquals("Input: posNeg(-4, -5, false)", false, exercises.posNeg(-4, -5, false));
		assertEquals("Input: posNeg(9, 12, true)", false, exercises.posNeg(9, 12, true));
		assertEquals("Input: posNeg(9, 12, false)", false, exercises.posNeg(9, 12, false));
	}

	/*
	 or35(3) → true
	 or35(10) → true
	 or35(8) → false
	 */
	@Test
	public void or35() {
		assertEquals("Input: or35(3)", true, exercises.or35(3));
		assertEquals("Input: or35(10)", true, exercises.or35(10));
		assertEquals("Input: or35(8)", false, exercises.or35(8));
		assertEquals("Input: or35(30)", true, exercises.or35(30));
	}

	/*
	 icyHot(120, -1) → true
	 icyHot(-1, 120) → true
	 icyHot(2, 120) → false
	 */
	@Test
	public void icyHot() {
		assertEquals("Input: icyHot(120, -1)", true, exercises.icyHot(120, -1));
		assertEquals("Input: icyHot(-1, 120)", true, exercises.icyHot(-1, 120));
		assertEquals("Input: icyHot(2, 120)", false, exercises.icyHot(2, 120));
		assertEquals("Input: icyHot(2, 99)", false, exercises.icyHot(2, 99));
		assertEquals("Input: icyHot(-2, 99)", false, exercises.icyHot(-2, 99));
		assertEquals("Input: icyHot(0, 100)", false, exercises.icyHot(0, 100));
	}

	/*
	 in1020(12, 99) → true
	 in1020(21, 12) → true
	 in1020(8, 99) → false
	 */
	@Test
	public void in1020() {
		assertEquals("Input: in1020(12, 99)", true, exercises.in1020(12, 99));
		assertEquals("Input: in1020(21, 12)", true, exercises.in1020(21, 12));
		assertEquals("Input: in1020(8, 99)", false, exercises.in1020(8, 99));
		assertEquals("Input: in1020(11, 19)", true, exercises.in1020(11, 19));
	}

	/*
	 hasTeen(13, 20, 10) → true
	 hasTeen(20, 19, 10) → true
	 hasTeen(20, 10, 13) → true
	 */
	@Test
	public void hasTeen() {
		assertEquals("Input: hasTeen(13, 20, 10)", true, exercises.hasTeen(13, 20, 10));
		assertEquals("Input: hasTeen(20, 19, 10)", true, exercises.hasTeen(20, 19, 10));
		assertEquals("Input: hasTeen(20, 10, 13)", true, exercises.hasTeen(20, 10, 13));
		assertEquals("Input: hasTeen(13, 14, 10)", true, exercises.hasTeen(13, 14, 10));
		assertEquals("Input: hasTeen(13, 10, 14)", true, exercises.hasTeen(13, 10, 14));
		assertEquals("Input: hasTeen(10, 13, 19)", true, exercises.hasTeen(10, 13, 19));
		assertEquals("Input: hasTeen(13, 14, 15)", true, exercises.hasTeen(13, 14, 15));
		assertEquals("Input: hasTeen(1, 2, 3)", false, exercises.hasTeen(1, 2, 3));
		assertEquals("Input: hasTeen(21, 22, 23)", false, exercises.hasTeen(21, 22, 23));
		assertEquals("Input: hasTeen(1, 2, 23)", false, exercises.hasTeen(1, 2, 23));
	}

	/*
	 loneTeen(13, 99) → true
	 loneTeen(21, 19) → true
	 loneTeen(13, 13) → false
	 */
	@Test
	public void loneTeen() {
		assertEquals("Input: loneTeen(13, 99)", true, exercises.loneTeen(13, 99));
		assertEquals("Input: loneTeen(21, 19)", true, exercises.loneTeen(21, 19));
		assertEquals("Input: loneTeen(13, 13)", false, exercises.loneTeen(13, 13));
		assertEquals("Input: loneTeen(12, 20)", false, exercises.loneTeen(12, 20));
		assertEquals("Input: loneTeen(20, 12)", false, exercises.loneTeen(20, 12));
		assertEquals("Input: loneTeen(12, 2)", false, exercises.loneTeen(12, 2));
		assertEquals("Input: loneTeen(23, 20)", false, exercises.loneTeen(23, 20));
	}

	/*
	 intMax(1, 2, 3) → 3
	 intMax(1, 3, 2) → 3
	 intMax(3, 2, 1) → 3
	 */
	@Test
	public void intMax() {
		assertEquals("Input: intMax(1, 2, 3)", 3, exercises.intMax(1, 2, 3));
		assertEquals("Input: intMax(1, 3, 2)", 3, exercises.intMax(1, 3, 2));
		assertEquals("Input: intMax(3, 2, 1)", 3, exercises.intMax(3, 2, 1));
		assertEquals("Input: intMax(4, 4, 1)", 4, exercises.intMax(4, 4, 1));
		assertEquals("Input: intMax(5, 2, 5)", 5, exercises.intMax(5, 2, 5));
		assertEquals("Input: intMax(3, 5, 5)", 5, exercises.intMax(3, 5, 5));
		assertEquals("Input: intMax(9, 1, 1)", 9, exercises.intMax(9, 1, 1));
		assertEquals("Input: intMax(9, 9, 9)", 9, exercises.intMax(9, 9, 9));
	}

	/*
	 in3050(30, 31) → true
	 in3050(30, 41) → false
	 in3050(40, 50) → true
	 */
	@Test
	public void in3050() {
		assertEquals("Input: in3050(30, 31)", true, exercises.in3050(30, 31));
		assertEquals("Input: in3050(30, 41)", false, exercises.in3050(30, 41));
		assertEquals("Input: in3050(40, 50)", true, exercises.in3050(40, 50));
		assertEquals("Input: in3050(20, 21)", false, exercises.in3050(20, 21));
		assertEquals("Input: in3050(30, 5)", false, exercises.in3050(30, 5));
		assertEquals("Input: in3050(40, 75)", false, exercises.in3050(40, 75));
	}

	/*
	 max1020(11, 19) → 19
	 max1020(19, 11) → 19
	 max1020(11, 9) → 11
	 */
	@Test
	public void max1020() {
		assertEquals("Input: max1020(11, 19)", 19, exercises.max1020(11, 19));
		assertEquals("Input: max1020(19, 11)", 19, exercises.max1020(19, 11));
		assertEquals("Input: max1020(11, 9)", 11, exercises.max1020(11, 9));
		assertEquals("Input: max1020(11, 21)", 11, exercises.max1020(11, 21));
		assertEquals("Input: max1020(9, 21)", 0, exercises.max1020(9, 21));
		assertEquals("Input: max1020(1, 9)", 0, exercises.max1020(1, 9));
		assertEquals("Input: max1020(21, 100)", 0, exercises.max1020(21, 100));
	}

	/*
	 cigarParty(30, false) → false
	 cigarParty(50, false) → true
	 cigarParty(70, true) → true
	 */
	@Test
	public void cigarParty() {
		assertEquals("Input: cigarParty(30, false)", false, exercises.cigarParty(30, false));
		assertEquals("Input: cigarParty(50, false)", true, exercises.cigarParty(50, false));
		assertEquals("Input: cigarParty(70, true)", true, exercises.cigarParty(70, true));
		assertEquals("Input: cigarParty(70, false)", false, exercises.cigarParty(70, false));
		assertEquals("Input: cigarParty(30, true)", false, exercises.cigarParty(30, true));
		assertEquals("Input: cigarParty(40, true)", true, exercises.cigarParty(40, true));
		assertEquals("Input: cigarParty(40, false)", true, exercises.cigarParty(40, false));
		assertEquals("Input: cigarParty(60, false)", true, exercises.cigarParty(60, false));
	}

	/*
	 dateFashion(5, 10) → 2
	 dateFashion(5, 2) → 0
	 dateFashion(5, 5) → 1
	 */
	@Test
	public void dateFashion() {
		assertEquals("Input: dateFashion(5, 10)", 2, exercises.dateFashion(5, 10));
		assertEquals("Input: dateFashion(10, 5)", 2, exercises.dateFashion(10, 5));
		assertEquals("Input: dateFashion(8, 8)", 2, exercises.dateFashion(8, 8));
		assertEquals("Input: dateFashion(2, 10)", 0, exercises.dateFashion(2, 10));
		assertEquals("Input: dateFashion(10, 1)", 0, exercises.dateFashion(10, 1));
		assertEquals("Input: dateFashion(5, 2)", 0, exercises.dateFashion(5, 2));
		assertEquals("Input: dateFashion(2, 2)", 0, exercises.dateFashion(2, 2));
		assertEquals("Input: dateFashion(5, 5)", 1, exercises.dateFashion(5, 5));
	}

	/*
	 squirrelPlay(70, false) → true
	 squirrelPlay(95, false) → false
	 squirrelPlay(95, true) → true
	 */
	@Test
	public void squirrelPlay() {
		assertEquals("Input: squirrelPlay(70, false)", true, exercises.squirrelPlay(70, false));
		assertEquals("Input: squirrelPlay(95, false)", false, exercises.squirrelPlay(95, false));
		assertEquals("Input: squirrelPlay(95, true)", true, exercises.squirrelPlay(95, true));
		assertEquals("Input: squirrelPlay(60, false)", true, exercises.squirrelPlay(60, false));
		assertEquals("Input: squirrelPlay(90, false)", true, exercises.squirrelPlay(90, false));
		assertEquals("Input: squirrelPlay(60, true)", true, exercises.squirrelPlay(60, true));
		assertEquals("Input: squirrelPlay(90, true)", true, exercises.squirrelPlay(90, true));
		assertEquals("Input: squirrelPlay(100, true)", true, exercises.squirrelPlay(100, true));
		assertEquals("Input: squirrelPlay(101, true)", false, exercises.squirrelPlay(101, true));
		assertEquals("Input: squirrelPlay(101, false)", false, exercises.squirrelPlay(101, false));
	}

	/*
	 yourCakeAndEatItToo(4.99, false) → "standard"
	 yourCakeAndEatItToo(4.99, true) → "standard"
	 yourCakeAndEatItToo(7.00, false) → "standard"
	 yourCakeAndEatItToo(7.00, true) → "special"
	 yourCakeAndEatItToo(10.00, false) → "standard"
	 yourCakeAndEatItToo(10.00, true) → "special"
	 yourCakeAndEatItToo(10.01, false) → "special"
	 yourCakeAndEatItToo(10.01, true) → "ginormous"
	 */
	@Test
	public void yourCakeAndEatItToo() {
		assertEquals("Input: yourCakeAndEatItToo(4.99, false)", "standard", exercises.yourCakeAndEatItToo(4.99, false));
		assertEquals("Input: yourCakeAndEatItToo(4.99, true)", "standard", exercises.yourCakeAndEatItToo(4.99, true));
		assertEquals("Input: yourCakeAndEatItToo(7.00, false)", "standard", exercises.yourCakeAndEatItToo(7.00, false));
		assertEquals("Input: yourCakeAndEatItToo(7.00, true)", "special", exercises.yourCakeAndEatItToo(7.00, true));
		assertEquals("Input: yourCakeAndEatItToo(10.00, false)", "standard", exercises.yourCakeAndEatItToo(10.00, false));
		assertEquals("Input: yourCakeAndEatItToo(10.00, true)", "special", exercises.yourCakeAndEatItToo(10.00, true));
		assertEquals("Input: yourCakeAndEatItToo(10.01, false)", "special", exercises.yourCakeAndEatItToo(10.01, false));
		assertEquals("Input: yourCakeAndEatItToo(10.01, true)", "ginormous", exercises.yourCakeAndEatItToo(10.01, true));
		assertEquals("Input: yourCakeAndEatItToo(15.00, false)", "special", exercises.yourCakeAndEatItToo(15.00, false));
		assertEquals("Input: yourCakeAndEatItToo(15.00, true)", "ginormous", exercises.yourCakeAndEatItToo(15.00, true));
		assertEquals("Input: yourCakeAndEatItToo(15.01, false)", "ginormous", exercises.yourCakeAndEatItToo(15.01, false));
		assertEquals("Input: yourCakeAndEatItToo(15.01, true)", "ginormous", exercises.yourCakeAndEatItToo(15.01, true));
	}

	/*
	 sortaSum(3, 4) → 7
	 sortaSum(9, 4) → 20
	 sortaSum(10, 11) → 21
	 */
	@Test
	public void sortaSum() {
		assertEquals("Input: sortaSum(3, 4)", 7, exercises.sortaSum(3, 4));
		assertEquals("Input: sortaSum(9, 4)", 20, exercises.sortaSum(9, 4));
		assertEquals("Input: sortaSum(10, 11)", 21, exercises.sortaSum(10, 11));
		assertEquals("Input: sortaSum(6, 4)", 20, exercises.sortaSum(6, 4));
		assertEquals("Input: sortaSum(10, 9)", 20, exercises.sortaSum(10, 9));
		assertEquals("Input: sortaSum(10, 10)", 20, exercises.sortaSum(10, 10));
		assertEquals("Input: sortaSum(5, 4)", 9, exercises.sortaSum(5, 4));
	}

	/*
	 alarmClock(1, false) → "7:00"
	 alarmClock(5, false) → "7:00"
	 alarmClock(0, false) → "10:00"
	 */
	@Test
	public void alarmClock() {
		assertEquals("Input: alarmClock(1, false)", "7:00", exercises.alarmClock(1, false));
		assertEquals("Input: alarmClock(5, false)", "7:00", exercises.alarmClock(5, false));
		assertEquals("Input: alarmClock(0, false)", "10:00", exercises.alarmClock(0, false));
		assertEquals("Input: alarmClock(2, false)", "7:00", exercises.alarmClock(2, false));
		assertEquals("Input: alarmClock(3, false)", "7:00", exercises.alarmClock(3, false));
		assertEquals("Input: alarmClock(4, false)", "7:00", exercises.alarmClock(4, false));
		assertEquals("Input: alarmClock(5, false)", "7:00", exercises.alarmClock(5, false));
		assertEquals("Input: alarmClock(6, false)", "10:00", exercises.alarmClock(6, false));
		assertEquals("Input: alarmClock(1, true)", "10:00", exercises.alarmClock(1, true));
		assertEquals("Input: alarmClock(2, true)", "10:00", exercises.alarmClock(2, true));
		assertEquals("Input: alarmClock(3, true)", "10:00", exercises.alarmClock(3, true));
		assertEquals("Input: alarmClock(4, true)", "10:00", exercises.alarmClock(4, true));
		assertEquals("Input: alarmClock(5, true)", "10:00", exercises.alarmClock(5, true));
		assertEquals("Input: alarmClock(0, true)", "off", exercises.alarmClock(0, true));
		assertEquals("Input: alarmClock(6, true)", "off", exercises.alarmClock(6, true));
	}

	/*
	 in1To10(5, false) → true
	 in1To10(11, false) → false
	 in1To10(11, true) → true
	 */
	@Test
	public void in1To10() {
		assertEquals("Input: in1To10(5, false)", true, exercises.in1To10(5, false));
		assertEquals("Input: in1To10(11, false)", false, exercises.in1To10(11, false));
		assertEquals("Input: in1To10(11, true)", true, exercises.in1To10(11, true));
		assertEquals("Input: in1To10(1, false)", true, exercises.in1To10(1, false));
		assertEquals("Input: in1To10(10, false)", true, exercises.in1To10(10, false));
		assertEquals("Input: in1To10(-1, false)", false, exercises.in1To10(-1, false));
		assertEquals("Input: in1To10(0, false)", false, exercises.in1To10(0, false));
		assertEquals("Input: in1To10(11, false)", false, exercises.in1To10(11, false));
		assertEquals("Input: in1To10(1, true)", true, exercises.in1To10(1, true));
		assertEquals("Input: in1To10(10, true)", true, exercises.in1To10(10, true));
		assertEquals("Input: in1To10(-1, true)", true, exercises.in1To10(-1, true));
		assertEquals("Input: in1To10(0, true)", true, exercises.in1To10(0, true));
		assertEquals("Input: in1To10(5, true)", false, exercises.in1To10(5, true));
	}

	/*
	 specialEleven(22) → true
	 specialEleven(23) → true
	 specialEleven(24) → false
	 */
	@Test
	public void specialEleven() {
		assertEquals("Input: specialEleven(22)", true, exercises.specialEleven(22));
		assertEquals("Input: specialEleven(23)", true, exercises.specialEleven(23));
		assertEquals("Input: specialEleven(24)", false, exercises.specialEleven(24));
		assertEquals("Input: specialEleven(11)", true, exercises.specialEleven(11));
		assertEquals("Input: specialEleven(12)", true, exercises.specialEleven(12));
		assertEquals("Input: specialEleven(13)", false, exercises.specialEleven(13));
		assertEquals("Input: specialEleven(10)", false, exercises.specialEleven(10));
	}

	/*
	 more20(20) → false
	 more20(21) → true
	 more20(22) → true
	 */
	@Test
	public void more20() {
		assertEquals("Input: more20(20)", false, exercises.more20(20));
		assertEquals("Input: more20(21)", true, exercises.more20(21));
		assertEquals("Input: more20(22)", true, exercises.more20(22));
		assertEquals("Input: more20(0)", false, exercises.more20(0));
		assertEquals("Input: more20(1)", true, exercises.more20(1));
		assertEquals("Input: more20(2)", true, exercises.more20(2));
		assertEquals("Input: more20(40)", false, exercises.more20(40));
		assertEquals("Input: more20(41)", true, exercises.more20(41));
		assertEquals("Input: more20(42)", true, exercises.more20(42));
	}

	/*
	 old35(3) → true
	 old35(10) → true
	 old35(15) → false
	 */
	@Test
	public void old35() {
		assertEquals("Input: old35(3)", true, exercises.old35(3));
		assertEquals("Input: old35(10)", true, exercises.old35(10));
		assertEquals("Input: old35(15)", false, exercises.old35(15));
		assertEquals("Input: old35(13)", false, exercises.old35(13));
	}

	/*
	 less20(18) → true
	 less20(19) → true
	 less20(20) → false
	 */
	@Test
	public void less20() {
		assertEquals("Input: less20(18)", true, exercises.less20(18));
		assertEquals("Input: less20(19)", true, exercises.less20(19));
		assertEquals("Input: less20(20)", false, exercises.less20(20));
		assertEquals("Input: less20(38)", true, exercises.less20(38));
		assertEquals("Input: less20(39)", true, exercises.less20(39));
		assertEquals("Input: less20(40)", false, exercises.less20(40));
		assertEquals("Input: less20(21)", false, exercises.less20(21));
		assertEquals("Input: less20(41)", false, exercises.less20(41));
	}

	/*
	 nearTen(12) → true
	 nearTen(17) → false
	 nearTen(19) → true
	 */
	@Test
	public void nearTen() {
		assertEquals("Input: nearTen(12)", true, exercises.nearTen(12));
		assertEquals("Input: nearTen(17)", false, exercises.nearTen(17));
		assertEquals("Input: nearTen(19)", true, exercises.nearTen(19));
		assertEquals("Input: nearTen(10)", true, exercises.nearTen(10));
		assertEquals("Input: nearTen(20)", true, exercises.nearTen(20));
		assertEquals("Input: nearTen(8)", true, exercises.nearTen(8));
		assertEquals("Input: nearTen(19)", true, exercises.nearTen(19));
		assertEquals("Input: nearTen(21)", true, exercises.nearTen(21));
		assertEquals("Input: nearTen(23)", false, exercises.nearTen(23));
	}

	/*
	 teenSum(3, 4) → 7
	 teenSum(10, 13) → 19
	 teenSum(13, 2) → 19
	 */
	@Test
	public void teenSum() {
		assertEquals("Input: teenSum(3, 4)", 7, exercises.teenSum(3, 4));
		assertEquals("Input: teenSum(10, 13)", 19, exercises.teenSum(10, 13));
		assertEquals("Input: teenSum(13, 2)", 19, exercises.teenSum(13, 2));
		assertEquals("Input: teenSum(15, 15)", 19, exercises.teenSum(15, 15));
		assertEquals("Input: teenSum(12, 20)", 32, exercises.teenSum(12, 20));
		assertEquals("Input: teenSum(21, 22)", 43, exercises.teenSum(21, 22));
	}

	/*
	 answerCell(false, false, false) → true
	 answerCell(false, false, true) → false
	 answerCell(true, false, false) → false
	 */
	@Test
	public void answerCell() {
		assertEquals("Input: answerCell(false, false, false)", true, exercises.answerCell(false, false, false));
		assertEquals("Input: answerCell(false, false, true)", false, exercises.answerCell(false, false, true));
		assertEquals("Input: answerCell(true, false, false)", false, exercises.answerCell(true, false, false));
		assertEquals("Input: answerCell(false, true, false)", true, exercises.answerCell(false, true, false));
		assertEquals("Input: answerCell(false, true, true)", false, exercises.answerCell(false, true, true));
		assertEquals("Input: answerCell(true, false, true)", false, exercises.answerCell(true, false, true));
		assertEquals("Input: answerCell(true, true, false)", true, exercises.answerCell(true, true, false));
		assertEquals("Input: answerCell(true, true, true)", false, exercises.answerCell(true, true, true));
	}

	/*
	 teaParty(6, 8) → 1
	 teaParty(3, 8) → 0
	 teaParty(20, 6) → 2
	 */
	@Test
	public void teaParty() {
		assertEquals("Input: teaParty(6, 8)", 1, exercises.teaParty(6, 8));
		assertEquals("Input: teaParty(3, 8)", 0, exercises.teaParty(3, 8));
		assertEquals("Input: teaParty(20, 6)", 2, exercises.teaParty(20, 6));
		assertEquals("Input: teaParty(5, 5)", 1, exercises.teaParty(5, 5));
		assertEquals("Input: teaParty(5, 10)", 2, exercises.teaParty(5, 10));
		assertEquals("Input: teaParty(10, 5)", 2, exercises.teaParty(10, 5));
		assertEquals("Input: teaParty(20, 25)", 1, exercises.teaParty(20, 25));
		assertEquals("Input: teaParty(4, 5)", 0, exercises.teaParty(4, 5));
		assertEquals("Input: teaParty(5, 4)", 0, exercises.teaParty(5, 4));
	}

	/*
	 twoAsOne(1, 2, 3) → true
	 twoAsOne(3, 1, 2) → true
	 twoAsOne(3, 2, 2) → false
	 */
	@Test
	public void twoAsOne() {
		assertEquals("Input: twoAsOne(1, 2, 3)", true, exercises.twoAsOne(1, 2, 3));
		assertEquals("Input: twoAsOne(3, 1, 2)", true, exercises.twoAsOne(3, 1, 2));
		assertEquals("Input: twoAsOne(3, 2, 2)", false, exercises.twoAsOne(3, 2, 2));
		assertEquals("Input: twoAsOne(3, 2, 1)", true, exercises.twoAsOne(3, 2, 1));
		assertEquals("Input: twoAsOne(2, 3, 1)", true, exercises.twoAsOne(2, 3, 1));
	}

	/*
	 inOrder(1, 2, 4, false) → true
	 inOrder(1, 2, 1, false) → false
	 inOrder(1, 1, 2, true) → true
	 */
	@Test
	public void inOrder() {
		assertEquals("Input: inOrder(1, 2, 4, false)", true, exercises.inOrder(1, 2, 4, false));
		assertEquals("Input: inOrder(1, 2, 1, false)", false, exercises.inOrder(1, 2, 1, false));
		assertEquals("Input: inOrder(1, 1, 2, true)", true, exercises.inOrder(1, 1, 2, true));
		assertEquals("Input: inOrder(4, 2, 3, false)", false, exercises.inOrder(4, 2, 3, false));
		assertEquals("Input: inOrder(1, 1, 2, false)", false, exercises.inOrder(1, 1, 2, false));
		assertEquals("Input: inOrder(1, 2, 2, false)", false, exercises.inOrder(1, 2, 2, false));
		assertEquals("Input: inOrder(5, 1, 2, true)", true, exercises.inOrder(5, 1, 2, true));
		assertEquals("Input: inOrder(5, 1, 1, true)", false, exercises.inOrder(5, 1, 1, true));
	}

	/*
	 inOrderEqual(2, 5, 11, false) → true
	 inOrderEqual(5, 7, 6, false) → false
	 inOrderEqual(5, 5, 7, true) → true
	 */
	@Test
	public void inOrderEqual() {
		assertEquals("Input: inOrderEqual(2, 5, 11, false)", true, exercises.inOrderEqual(2, 5, 11, false));
		assertEquals("Input: inOrderEqual(5, 7, 6, false)", false, exercises.inOrderEqual(5, 7, 6, false));
		assertEquals("Input: inOrderEqual(5, 5, 7, true)", true, exercises.inOrderEqual(5, 5, 7, true));
		assertEquals("Input: inOrderEqual(5, 7, 6, true)", false, exercises.inOrderEqual(5, 7, 6, true));
		assertEquals("Input: inOrderEqual(5, 5, 5, true)", true, exercises.inOrderEqual(5, 5, 5, true));
		assertEquals("Input: inOrderEqual(1, 5, 5, true)", true, exercises.inOrderEqual(1, 5, 5, true));
		assertEquals("Input: inOrderEqual(6, 5, 5, true)", false, exercises.inOrderEqual(6, 5, 5, true));
	}

	/*
	 loneSum(1, 2, 3) → 6
	 loneSum(3, 2, 3) → 2
	 loneSum(3, 3, 3) → 0
	 */
	@Test
	public void loneSum() {
		assertEquals("Input: loneSum(1, 2, 3)", 6, exercises.loneSum(1, 2, 3));
		assertEquals("Input: loneSum(3, 2, 3)", 2, exercises.loneSum(3, 2, 3));
		assertEquals("Input: loneSum(3, 3, 3)", 0, exercises.loneSum(3, 3, 3));
		assertEquals("Input: loneSum(0, 1, 1)", 0, exercises.loneSum(0, 1, 1));
		assertEquals("Input: loneSum(3, 1, 1)", 3, exercises.loneSum(3, 1, 1));
		assertEquals("Input: loneSum(1, 1, 5)", 5, exercises.loneSum(1, 1, 5));
	}

	/*
	 luckySum(1, 2, 3) → 6
	 luckySum(1, 2, 13) → 3
	 luckySum(1, 13, 3) → 1
	 luckySum(13, 1, 3) → 3
	 luckySum(13, 13, 3) → 0
	 */
	@Test
	public void luckySum() {
		assertEquals("Input: luckySum(1, 2, 3)", 6, exercises.luckySum(1, 2, 3));
		assertEquals("Input: luckySum(1, 2, 13)", 3, exercises.luckySum(1, 2, 13));
		assertEquals("Input: luckySum(1, 13, 3)", 1, exercises.luckySum(1, 13, 3));
		assertEquals("Input: luckySum(13, 1, 3)", 3, exercises.luckySum(13, 1, 3));
		assertEquals("Input: luckySum(13, 13, 3)", 0, exercises.luckySum(13, 13, 3));
		assertEquals("Input: luckySum(13, 13, 13)", 0, exercises.luckySum(13, 13, 13));
	}

}
