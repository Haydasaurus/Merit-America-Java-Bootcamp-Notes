package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	Exercises exercises = new Exercises();

	@Test
	public void helloName() {
		assertEquals("Input: helloName(\"Bob\")", "Hello Bob!", exercises.helloName("Bob"));
		assertEquals("Input: helloName(\"Alice\")", "Hello Alice!", exercises.helloName("Alice"));
		assertEquals("Input: helloName(\"X\")", "Hello X!", exercises.helloName("X"));
		assertEquals("Input: helloName(\"Dolly\")", "Hello Dolly!", exercises.helloName("Dolly"));
		assertEquals("Input: helloName(\"Alpha\")", "Hello Alpha!", exercises.helloName("Alpha"));
		assertEquals("Input: helloName(\"Omega\")", "Hello Omega!", exercises.helloName("Omega"));
		assertEquals("Input: helloName(\"Goodbye\")", "Hello Goodbye!", exercises.helloName("Goodbye"));
		assertEquals("Input: helloName(\"ho ho ho\")", "Hello ho ho ho!", exercises.helloName("ho ho ho"));
		assertEquals("Input: helloName(\"xyz\")", "Hello xyz!", exercises.helloName("xyz"));
		assertEquals("Input: helloName(\"Hello\")", "Hello Hello!", exercises.helloName("Hello"));
	}

	@Test
	public void makeAbba() {
		assertEquals("Input: makeAbba(\"Hi\", \"Bye\")", "HiByeByeHi", exercises.makeAbba("Hi", "Bye"));
		assertEquals("Input: makeAbba(\"Yo\", \"Alice\")", "YoAliceAliceYo", exercises.makeAbba("Yo", "Alice"));
		assertEquals("Input: makeAbba(\"What\", \"Up\")", "WhatUpUpWhat", exercises.makeAbba("What", "Up"));
		assertEquals("Input: makeAbba(\"aaa\", \"bbb\")", "aaabbbbbbaaa", exercises.makeAbba("aaa", "bbb"));
		assertEquals("Input: makeAbba(\"x\", \"y\")", "xyyx", exercises.makeAbba("x", "y"));
		assertEquals("Input: makeAbba(\"x\", \"\")", "xx", exercises.makeAbba("x", ""));
		assertEquals("Input: makeAbba(\"\", \"y\")", "yy", exercises.makeAbba("", "y"));
		assertEquals("Input: makeAbba(\"Bo\", \"Ya\")", "BoYaYaBo", exercises.makeAbba("Bo", "Ya"));
		assertEquals("Input: makeAbba(\"Ya\", \"Ya\")", "YaYaYaYa", exercises.makeAbba("Ya", "Ya"));
	}

	@Test
	public void makeTags() {
		assertEquals("Input: makeTags(\"i\", \"Yay\")", "<i>Yay</i>", exercises.makeTags("i", "Yay"));
		assertEquals("Input: makeTags(\"i\", \"Hello\")", "<i>Hello</i>", exercises.makeTags("i", "Hello"));
		assertEquals("Input: makeTags(\"cite\", \"Yay\")", "<cite>Yay</cite>", exercises.makeTags("cite", "Yay"));
		assertEquals("Input: makeTags(\"address\", \"here\")", "<address>here</address>",
				exercises.makeTags("address", "here"));
		assertEquals("Input: makeTags(\"body\", \"Heart\")", "<body>Heart</body>", exercises.makeTags("body", "Heart"));
		assertEquals("Input: makeTags(\"i\", \"i\")", "<i>i</i>", exercises.makeTags("i", "i"));
		assertEquals("Input: makeTags(\"i\", \"\")", "<i></i>", exercises.makeTags("i", ""));
	}

	@Test
	public void makeOutWord() {
		assertEquals("Input: makeOutWord(\"<<>>\", \"Yay\")", "<<Yay>>", exercises.makeOutWord("<<>>", "Yay"));
		assertEquals("Input: makeOutWord(\"<<>>\", \"WooHoo\")", "<<WooHoo>>", exercises.makeOutWord("<<>>", "WooHoo"));
		assertEquals("Input: makeOutWord(\"[[]]\", \"word\")", "[[word]]", exercises.makeOutWord("[[]]", "word"));
		assertEquals("Input: makeOutWord(\"HHoo\", \"Hello\")", "HHHellooo", exercises.makeOutWord("HHoo", "Hello"));
		assertEquals("Input: makeOutWord(\"abyz\", \"YAY\")", "abYAYyz", exercises.makeOutWord("abyz", "YAY"));
	}

	@Test
	public void extraEnd() {
		assertEquals("Input: extraEnd(\"Hello\")", "lololo", exercises.extraEnd("Hello"));
		assertEquals("Input: extraEnd(\"ab\")", "ababab", exercises.extraEnd("ab"));
		assertEquals("Input: extraEnd(\"Hi\")", "HiHiHi", exercises.extraEnd("Hi"));
		assertEquals("Input: extraEnd(\"Candy\")", "dydydy", exercises.extraEnd("Candy"));
		assertEquals("Input: extraEnd(\"Code\")", "dedede", exercises.extraEnd("Code"));
	}

	@Test
	public void firstTwo() {
		assertEquals("Input: firstTwo(\"Hello\")", "He", exercises.firstTwo("Hello"));
		assertEquals("Input: firstTwo(\"abcdefg\")", "ab", exercises.firstTwo("abcdefg"));
		assertEquals("Input: firstTwo(\"ab\")", "ab", exercises.firstTwo("ab"));
		assertEquals("Input: firstTwo(\"a\")", "a", exercises.firstTwo("a"));
		assertEquals("Input: firstTwo(\"\")", "", exercises.firstTwo(""));
		assertEquals("Input: firstTwo(\"Kitten\")", "Ki", exercises.firstTwo("Kitten"));
		assertEquals("Input: firstTwo(\"hi\")", "hi", exercises.firstTwo("hi"));
		assertEquals("Input: firstTwo(\"hiya\")", "hi", exercises.firstTwo("hiya"));
	}

	@Test
	public void firstHalf() {
		assertEquals("Input: firstHalf(\"WooHoo\")", "Woo", exercises.firstHalf("WooHoo"));
		assertEquals("Input: firstHalf(\"HelloThere\")", "Hello", exercises.firstHalf("HelloThere"));
		assertEquals("Input: firstHalf(\"abcdef\")", "abc", exercises.firstHalf("abcdef"));
		assertEquals("Input: firstHalf(\"ab\")", "a", exercises.firstHalf("ab"));
		assertEquals("Input: firstHalf(\"\")", "", exercises.firstHalf(""));
		assertEquals("Input: firstHalf(\"0123456789\")", "01234", exercises.firstHalf("0123456789"));
		assertEquals("Input: firstHalf(\"kitten\")", "kit", exercises.firstHalf("kitten"));
	}

	@Test
	public void withoutEnd() {
		assertEquals("Input: withoutEnd(\"Hello\")", "ell", exercises.withoutEnd("Hello"));
		assertEquals("Input: withoutEnd(\"java\")", "av", exercises.withoutEnd("java"));
		assertEquals("Input: withoutEnd(\"coding\")", "odin", exercises.withoutEnd("coding"));
		assertEquals("Input: withoutEnd(\"code\")", "od", exercises.withoutEnd("code"));
		assertEquals("Input: withoutEnd(\"Chocolate!\")", "hocolate", exercises.withoutEnd("Chocolate!"));
		assertEquals("Input: withoutEnd(\"coding\")", "odin", exercises.withoutEnd("coding"));
		assertEquals("Input: withoutEnd(\"kitten\")", "itte", exercises.withoutEnd("kitten"));
		assertEquals("Input: withoutEnd(\"woohoo\")", "ooho", exercises.withoutEnd("woohoo"));
	}

	@Test
	public void comboString() {
		assertEquals("Input: comboString(\"Hello\", \"hi\")", "hiHellohi", exercises.comboString("Hello", "hi"));
		assertEquals("Input: comboString(\"hi\", \"Hello\")", "hiHellohi", exercises.comboString("hi", "Hello"));
		assertEquals("Input: comboString(\"aaa\", \"b\")", "baaab", exercises.comboString("aaa", "b"));
		assertEquals("Input: comboString(\"b\", \"aaa\")", "baaab", exercises.comboString("b", "aaa"));
		assertEquals("Input: comboString(\"aaa\", \"\")", "aaa", exercises.comboString("aaa", ""));
		assertEquals("Input: comboString(\"\", \"bb\")", "bb", exercises.comboString("", "bb"));
		assertEquals("Input: comboString(\"aaa\", \"1234\")", "aaa1234aaa", exercises.comboString("aaa", "1234"));
		assertEquals("Input: comboString(\"aaa\", \"bb\")", "bbaaabb", exercises.comboString("aaa", "bb"));
		assertEquals("Input: comboString(\"a\", \"bb\")", "abba", exercises.comboString("a", "bb"));
		assertEquals("Input: comboString(\"bb\", \"a\")", "abba", exercises.comboString("bb", "a"));
		assertEquals("Input: comboString(\"xyz\", \"ab\")", "abxyzab", exercises.comboString("xyz", "ab"));
	}

	@Test
	public void nonStart() {
		assertEquals("Input: nonStart(\"Hello\", \"There\")", "ellohere", exercises.nonStart("Hello", "There"));
		assertEquals("Input: nonStart(\"java\", \"code\")", "avaode", exercises.nonStart("java", "code"));
		assertEquals("Input: nonStart(\"shotl\", \"java\")", "hotlava", exercises.nonStart("shotl", "java"));
		assertEquals("Input: nonStart(\"ab\", \"xy\")", "by", exercises.nonStart("ab", "xy"));
		assertEquals("Input: nonStart(\"ab\", \"x\")", "b", exercises.nonStart("ab", "x"));
		assertEquals("Input: nonStart(\"x\", \"ac\")", "c", exercises.nonStart("x", "ac"));
		assertEquals("Input: nonStart(\"a\", \"x\")", "", exercises.nonStart("a", "x"));
		assertEquals("Input: nonStart(\"kit\", \"kat\")", "itat", exercises.nonStart("kit", "kat"));
		assertEquals("Input: nonStart(\"mart\", \"dart\")", "artart", exercises.nonStart("mart", "dart"));
	}

	@Test
	public void left2() {
		assertEquals("Input: left2(\"Hello\")", "lloHe", exercises.left2("Hello"));
		assertEquals("Input: left2(\"java\")", "vaja", exercises.left2("java"));
		assertEquals("Input: left2(\"Hi\")", "Hi", exercises.left2("Hi"));
		assertEquals("Input: left2(\"code\")", "deco", exercises.left2("code"));
		assertEquals("Input: left2(\"cat\")", "tca", exercises.left2("cat"));
		assertEquals("Input: left2(\"12345\")", "34512", exercises.left2("12345"));
		assertEquals("Input: left2(\"Chocolate\")", "ocolateCh", exercises.left2("Chocolate"));
		assertEquals("Input: left2(\"bricks\")", "icksbr", exercises.left2("bricks"));
	}

	@Test
	public void right2() {
		assertEquals("Input: right2(\"Hello\")", "loHel", exercises.right2("Hello"));
		assertEquals("Input: right2(\"java\")", "vaja", exercises.right2("java"));
		assertEquals("Input: right2(\"Hi\")", "Hi", exercises.right2("Hi"));
		assertEquals("Input: right2(\"code\")", "deco", exercises.right2("code"));
		assertEquals("Input: right2(\"cat\")", "atc", exercises.right2("cat"));
		assertEquals("Input: right2(\"12345\")", "45123", exercises.right2("12345"));
	}

	@Test
	public void theEnd() {
		assertEquals("Input: theEnd(\"Hello\", true)", "H", exercises.theEnd("Hello", true));
		assertEquals("Input: theEnd(\"Hello\", false)", "o", exercises.theEnd("Hello", false));
		assertEquals("Input: theEnd(\"oh\", true)", "o", exercises.theEnd("oh", true));
		assertEquals("Input: theEnd(\"oh\", false)", "h", exercises.theEnd("oh", false));
		assertEquals("Input: theEnd(\"x\", true)", "x", exercises.theEnd("x", true));
		assertEquals("Input: theEnd(\"x\", false)", "x", exercises.theEnd("x", false));
		assertEquals("Input: theEnd(\"java\", true)", "j", exercises.theEnd("java", true));
		assertEquals("Input: theEnd(\"chocolate\", false)", "e", exercises.theEnd("chocolate", false));
		assertEquals("Input: theEnd(\"1234\", true)", "1", exercises.theEnd("1234", true));
		assertEquals("Input: theEnd(\"code\", false)", "e", exercises.theEnd("code", false));
	}

	@Test
	public void withoutEnd2() {
		assertEquals("Input:withoutEnd2(\"Hello\") ", "ell", exercises.withoutEnd2("Hello"));
		assertEquals("Input: withoutEnd2(\"abc\")", "b", exercises.withoutEnd2("abc"));
		assertEquals("Input: withoutEnd2(\"ab\")", "", exercises.withoutEnd2("ab"));
		assertEquals("Input: withoutEnd2(\"a\")", "", exercises.withoutEnd2("a"));
		assertEquals("Input: withoutEnd2(\"\"))", "", exercises.withoutEnd2(""));
		assertEquals("Input: withoutEnd2(\"coldy\")", "old", exercises.withoutEnd2("coldy"));
		assertEquals("Input: withoutEnd2(\"java code\")", "ava cod", exercises.withoutEnd2("java code"));
	}

	@Test
	public void middleTwo() {
		assertEquals("Input: middleTwo(\"string\")", "ri", exercises.middleTwo("string"));
		assertEquals("Input: middleTwo(\"code\")", "od", exercises.middleTwo("code"));
		assertEquals("Input: middleTwo(\"Practice\")", "ct", exercises.middleTwo("Practice"));
		assertEquals("Input: middleTwo(\"ab\")", "ab", exercises.middleTwo("ab"));
		assertEquals("Input: middleTwo(\"0123456789\")", "45", exercises.middleTwo("0123456789"));
	}

	@Test
	public void endsLy() {
		assertEquals("Input: endsLy(\"oddly\")", true, exercises.endsLy("oddly"));
		assertEquals("Input: endsLy(\"y\")", false, exercises.endsLy("y"));
		assertEquals("Input: endsLy(\"oddy\")", false, exercises.endsLy("oddy"));
		assertEquals("Input: endsLy(\"oddl\")", false, exercises.endsLy("oddl"));
		assertEquals("Input: endsLy(\"olydd\")", false, exercises.endsLy("olydd"));
		assertEquals("Input: endsLy(\"ly\")", true, exercises.endsLy("ly"));
		assertEquals("Input: endsLy(\"\")", false, exercises.endsLy(""));
		assertEquals("Input: endsLy(\"falsey\")", false, exercises.endsLy("falsey"));
		assertEquals("Input: endsLy(\"evenly\")", true, exercises.endsLy("evenly"));
	}

	@Test
	public void nTwice() {
		assertEquals("Input: nTwice(\"Hello\", 2)", "Helo", exercises.nTwice("Hello", 2));
		assertEquals("Input: nTwice(\"Chocolate\", 3)", "Choate", exercises.nTwice("Chocolate", 3));
		assertEquals("Input: nTwice(\"Chocolate\", 1)", "Ce", exercises.nTwice("Chocolate", 1));
		assertEquals("Input: Twice(\"Chocolate\", 0)", "", exercises.nTwice("Chocolate", 0));
		assertEquals("Input: nTwice(\"Hello\", 4)", "Hellello", exercises.nTwice("Hello", 4));
		assertEquals("Input: nTwice(\"Code\", 4)", "CodeCode", exercises.nTwice("Code", 4));
		assertEquals("Input: nTwice(\"Code\", 2)", "Code", exercises.nTwice("Code", 2));
	}

	@Test
	public void twoChar() {
		assertEquals("Input: twoChar(\"java\", 0)", "ja", exercises.twoChar("java", 0));
		assertEquals("Input: twoChar(\"java\", 2)", "va", exercises.twoChar("java", 2));
		assertEquals("Input: twoChar(\"java\", 3)", "ja", exercises.twoChar("java", 3));
		assertEquals("Input: twoChar(\"java\", 4)", "ja", exercises.twoChar("java", 4));
		assertEquals("Input: twoChar(\"java\", -1)", "ja", exercises.twoChar("java", -1));
		assertEquals("Input: twoChar(\"Hello\", 0)", "He", exercises.twoChar("Hello", 0));
		assertEquals("Input: twoChar(\"Hello\", 1)", "el", exercises.twoChar("Hello", 1));
		assertEquals("Input: twoChar(\"Hello\", 99)", "He", exercises.twoChar("Hello", 99));
		assertEquals("Input: twoChar(\"Hello\", 3)", "lo", exercises.twoChar("Hello", 3));
		assertEquals("Input: twoChar(\"Hello\", 4)", "He", exercises.twoChar("Hello", 4));
		assertEquals("Input: twoChar(\"Hello\", 5)", "He", exercises.twoChar("Hello", 5));
		assertEquals("Input: twoChar(\"Hello\", -7)", "He", exercises.twoChar("Hello", -7));
		assertEquals("Input: twoChar(\"Hello\", 6)", "He", exercises.twoChar("Hello", 6));
		assertEquals("Input: twoChar(\"Hello\", -1)", "He", exercises.twoChar("Hello", -1));
		assertEquals("Input: twoChar(\"yay\", 0)", "ya", exercises.twoChar("yay", 0));
	}

	@Test
	public void middleThree() {
		assertEquals("Input: middleThree(\"Candy\")", "and", exercises.middleThree("Candy"));
		assertEquals("Input: middleThree(\"and\")", "and", exercises.middleThree("and"));
		assertEquals("Input: middleThree(\"solving\")", "lvi", exercises.middleThree("solving"));
		assertEquals("Input: middleThree(\"Hi yet Hi\")", "yet", exercises.middleThree("Hi yet Hi"));
		assertEquals("Input: middleThree(\"java yet java\")", "yet", exercises.middleThree("java yet java"));
		assertEquals("Input: middleThree(\"Chocolate\")", "col", exercises.middleThree("Chocolate"));
		assertEquals("Input: middleThree(\"XabcxyzabcX\")", "xyz", exercises.middleThree("XabcxyzabcX"));
	}

	@Test
	public void hasBad() {
		assertEquals("Input: hasBad(\"badxx\")", true, exercises.hasBad("badxx"));
		assertEquals("Input: hasBad(\"xbadxx\")", true, exercises.hasBad("xbadxx"));
		assertEquals("Input: hasBad(\"xxbadxx\")", false, exercises.hasBad("xxbadxx"));
		assertEquals("Input: hasBad(\"code\")", false, exercises.hasBad("code"));
		assertEquals("Input: hasBad(\"bad\")", true, exercises.hasBad("bad"));
		assertEquals("Input: hasBad(\"ba\")", false, exercises.hasBad("ba"));
		assertEquals("Input: hasBad(\"xba\")", false, exercises.hasBad("xba"));
		assertEquals("Input: hasBad(\"xbad\")", true, exercises.hasBad("xbad"));
		assertEquals("Input: hasBad(\"\")", false, exercises.hasBad(""));
		assertEquals("Input: hasBad(\"badyy\")", true, exercises.hasBad("badyy"));
	}

	@Test
	public void stringTimes() {
		assertEquals("Input: stringTimes(\"Hi\", 2)", "HiHi", exercises.stringTimes("Hi", 2));
		assertEquals("Input: stringTimes(\"Hi\", 3)", "HiHiHi", exercises.stringTimes("Hi", 3));
		assertEquals("Input: stringTimes(\"Hi\", 1)", "Hi", exercises.stringTimes("Hi", 1));
		assertEquals("Input: stringTimes(\"Hi\", 0)", "", exercises.stringTimes("Hi", 0));
		assertEquals("Input: stringTimes(\"Hi\", 5)", "HiHiHiHiHi", exercises.stringTimes("Hi", 5));
		assertEquals("Input: stringTimes(\"Oh Boy!\", 2)", "Oh Boy!Oh Boy!", exercises.stringTimes("Oh Boy!", 2));
		assertEquals("Input: stringTimes(\"x\", 4)", "xxxx", exercises.stringTimes("x", 4));
		assertEquals("Input: stringTimes(\"\", 4)", "", exercises.stringTimes("", 4));
		assertEquals("Input: stringTimes(\"code\", 2)", "codecode", exercises.stringTimes("code", 2));
		assertEquals("Input: stringTimes(\"code\", 3)", "codecodecode", exercises.stringTimes("code", 3));
	}

	@Test
	public void frontTimes() {
		assertEquals("Input: frontTimes(\"Chocolate\", 2)", "ChoCho", exercises.frontTimes("Chocolate", 2));
		assertEquals("Input: frontTimes(\"Chocolate\", 3)", "ChoChoCho", exercises.frontTimes("Chocolate", 3));
		assertEquals("Input: frontTimes(\"Abc\", 3)", "AbcAbcAbc", exercises.frontTimes("Abc", 3));
		assertEquals("Input: frontTimes(\"Ab\", 4)", "AbAbAbAb", exercises.frontTimes("Ab", 4));
		assertEquals("Input: frontTimes(\"A\", 4)", "AAAA", exercises.frontTimes("A", 4));
		assertEquals("Input: frontTimes(\"\", 4)", "", exercises.frontTimes("", 4));
		assertEquals("Input: frontTimes(\"Abc\", 0)", "", exercises.frontTimes("Abc", 0));
	}

	@Test
	public void countXX() {
		assertEquals("Input: countXX(\"abcxx\")", 1, exercises.countXX("abcxx"));
		assertEquals("Input: countXX(\"xxx\")", 2, exercises.countXX("xxx"));
		assertEquals("Input: countXX(\"xxxx\")", 3, exercises.countXX("xxxx"));
		assertEquals("Input: countXX(\"\")", 0, exercises.countXX(""));
		assertEquals("Input: countXX(\"Hello there\")", 0, exercises.countXX("Hello there"));
		assertEquals("Input: countXX(\"Hexxo thxxe\")", 2, exercises.countXX("Hexxo thxxe"));
		assertEquals("Input: countXX(\"\")", 0, exercises.countXX(""));
		assertEquals("Input: countXX(\"Kittens\")", 0, exercises.countXX("Kittens"));
		assertEquals("Input: countXX(\"Kittensxxx\")", 2, exercises.countXX("Kittensxxx"));
	}

	@Test
	public void doubleX() {
		assertEquals("Input: doubleX(\"axxbb\")", true, exercises.doubleX("axxbb"));
		assertEquals("Input: doubleX(\"axaxax\")", false, exercises.doubleX("axaxax"));
		assertEquals("Input: doubleX(\"xxxxx\")", true, exercises.doubleX("xxxxx"));
		assertEquals("Input: doubleX(\"xaxxx\")", false, exercises.doubleX("xaxxx"));
		assertEquals("Input: doubleX(\"aaaax\")", false, exercises.doubleX("aaaax"));
		assertEquals("Input: doubleX(\"\")", false, exercises.doubleX(""));
		assertEquals("Input: doubleX(\"abc\")", false, exercises.doubleX("abc"));
		assertEquals("Input: doubleX(\"x\")", false, exercises.doubleX("x"));
		assertEquals("Input: doubleX(\"xx\")", true, exercises.doubleX("xx"));
		assertEquals("Input: doubleX(\"xax\")", false, exercises.doubleX("xax"));
		assertEquals("Input: doubleX(\"xaxx\")", false, exercises.doubleX("xaxx"));
	}

	@Test
	public void stringBits() {
		assertEquals("Input: stringBits(\"Hello\")", "Hlo", exercises.stringBits("Hello"));
		assertEquals("Input: stringBits(\"Hi\")", "H", exercises.stringBits("Hi"));
		assertEquals("Input: stringBits(\"Heeololeo\")", "Hello", exercises.stringBits("Heeololeo"));
		assertEquals("Input: stringBits(\"HiHiHi\")", "HHH", exercises.stringBits("HiHiHi"));
		assertEquals("Input: stringBits(\"\")", "", exercises.stringBits(""));
		assertEquals("Input: stringBits(\"Greetings\")", "Getns", exercises.stringBits("Greetings"));
		assertEquals("Input: stringBits(\"Chocoate\")", "Coot", exercises.stringBits("Chocoate"));
		assertEquals("Input: stringBits(\"pi\")", "p", exercises.stringBits("pi"));
		assertEquals("Input: stringBits(\"Hello Kitten\")", "HloKte", exercises.stringBits("Hello Kitten"));
		assertEquals("Input: stringBits(\"hxaxpxpxy\")", "happy", exercises.stringBits("hxaxpxpxy"));
	}

	@Test
	public void stringSplosion() {
		assertEquals("Input: stringSplosion(\"Code\")", "CCoCodCode", exercises.stringSplosion("Code"));
		assertEquals("Input: stringSplosion(\"abc\")", "aababc", exercises.stringSplosion("abc"));
		assertEquals("Input: stringSplosion(\"abc\")", "aab", exercises.stringSplosion("ab"));
		assertEquals("Input: stringSplosion(\"x\")", "x", exercises.stringSplosion("x"));
		assertEquals("Input: stringSplosion(\"fade\")", "ffafadfade", exercises.stringSplosion("fade"));
		assertEquals("Input: stringSplosion(\"There\")", "TThTheTherThere", exercises.stringSplosion("There"));
		assertEquals("Input: stringSplosion(\"Kitten\")", "KKiKitKittKitteKitten", exercises.stringSplosion("Kitten"));
		assertEquals("Input: stringSplosion(\"Bye\")", "BByBye", exercises.stringSplosion("Bye"));
		assertEquals("Input: stringSplosion(\"Good\")", "GGoGooGood", exercises.stringSplosion("Good"));
		assertEquals("Input: stringSplosion(\"Bad\")", "BBaBad", exercises.stringSplosion("Bad"));
	}

	@Test
	public void last2() {
		assertEquals("Input: last2(\"hixxhi\")", 1, exercises.last2("hixxhi"));
		assertEquals("Input: last2(\"xaxxaxaxx\")", 1, exercises.last2("xaxxaxaxx"));
		assertEquals("Input: last2(\"axxxaaxx\")", 2, exercises.last2("axxxaaxx"));
		assertEquals("Input: last2(\"xxaxxaxxaxx\")", 3, exercises.last2("xxaxxaxxaxx"));
		assertEquals("Input: last2(\"xaxaxaxx\")", 0, exercises.last2("xaxaxaxx"));
		assertEquals("Input: last2(\"xxxx\")", 2, exercises.last2("xxxx"));
		assertEquals("Input: last2(\"13121312\")", 1, exercises.last2("13121312"));
		assertEquals("Input: last2(\"11212\")", 1, exercises.last2("11212"));
		assertEquals("Input: last2(\"13121311\")", 0, exercises.last2("13121311"));
		assertEquals("Input: last2(\"1717171\")", 2, exercises.last2("1717171"));
		assertEquals("Input: last2(\"hi\")", 0, exercises.last2("hi"));
		assertEquals("Input: last2(\"h\")", 0, exercises.last2("h"));
		assertEquals("Input: last2(\"\")", 0, exercises.last2(""));
	}

	@Test
	public void stringX() {
		assertEquals("Input: stringX(\"xxHxix\")", "xHix", exercises.stringX("xxHxix"));
		assertEquals("Input: stringX(\"abxxxcd\")", "abcd", exercises.stringX("abxxxcd"));
		assertEquals("Input: stringX(\"xabxxxcdx\")", "xabcdx", exercises.stringX("xabxxxcdx"));
		assertEquals("Input: stringX(\"xKittenx\")", "xKittenx", exercises.stringX("xKittenx"));
		assertEquals("Input: stringX(\"Hello\")", "Hello", exercises.stringX("Hello"));
		assertEquals("Input: stringX(\"xx\")", "xx", exercises.stringX("xx"));
		assertEquals("Input: stringX(\"x\")", "x", exercises.stringX("x"));
		assertEquals("Input: stringX(\"\")", "", exercises.stringX(""));
	}

	@Test
	public void altPairs() {
		assertEquals("Input: altPairs(\"kitten\")", "kien", exercises.altPairs("kitten"));
		assertEquals("Input: altPairs(\"Chocolate\")", "Chole", exercises.altPairs("Chocolate"));
		assertEquals("Input: altPairs(\"CodingHorror\")", "Congrr", exercises.altPairs("CodingHorror"));
		assertEquals("Input: altPairs(\"yak\")", "ya", exercises.altPairs("yak"));
		assertEquals("Input: altPairs(\"ya\")", "ya", exercises.altPairs("ya"));
		assertEquals("Input: altPairs(\"y\")", "y", exercises.altPairs("y"));
		assertEquals("Input: altPairs(\"\")", "", exercises.altPairs(""));
		assertEquals("Input: altPairs(\"ThisThatTheOther\")", "ThThThth", exercises.altPairs("ThisThatTheOther"));
	}

	@Test
	public void stringYak() {
		assertEquals("Input: stringYak(\"yakpak\")", "pak", exercises.stringYak("yakpak"));
		assertEquals("Input: stringYak(\"pakyak\")", "pak", exercises.stringYak("pakyak"));
		assertEquals("Input: stringYak(\"yak123ya\")", "123ya", exercises.stringYak("yak123ya"));
		assertEquals("Input: stringYak(\"yak\")", "", exercises.stringYak("yak"));
		assertEquals("Input: stringYak(\"yakxxxyak\")", "xxx", exercises.stringYak("yakxxxyak"));
		assertEquals("Input: stringYak(\"HiyakHi\")", "HiHi", exercises.stringYak("HiyakHi"));
		assertEquals("Input: stringYak(\"xxxyakyyyakzzz\")", "xxxyyzzz", exercises.stringYak("xxxyakyyyakzzz"));
	}

}
