package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class HomeworkAssignmentTest {

	@Before
	public void homeworkAssignmentRequiredMethods() {

		Class klass = HomeworkAssignment.class;

		Constructor<HomeworkAssignment> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class);
		assertTrue("You do not have the required constructor(int, String)", constructor != null);

		Method method = SafeReflection.getMethod(klass, "getPossibleMarks");
		assertTrue("HomeworkAssignment class needs the getPossibleMarks() method.", method != null);
		assertTrue("getPossibleMarks() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setPossibleMarks", Integer.TYPE);
		assertTrue("HomeworkAssignment class should not have a setPossibleMarks(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getEarnedMarks");
		assertTrue("HomeworkAssignment class needs the getEarnedMarks() method.", method != null);
		assertTrue("getEarnedMarks() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setEarnedMarks", Integer.TYPE);
		assertTrue("HomeworkAssignment class needs the setEarnedMarks(int) method.", method != null);
		assertTrue("setEarnedMarks(int) method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "getSubmitterName");
		assertTrue("HomeworkAssignment class needs the getSubmitterName() method.", method != null);
		assertTrue("getSubmitterName() method needs to return type: String", method.getReturnType() == String.class);

		method = SafeReflection.getMethod(klass, "setSubmitterName", String.class);
		assertTrue("HomeworkAssignment class should not have a setSubmitterName(String) method", method == null);

		method = SafeReflection.getMethod(klass, "getLetterGrade");
		assertTrue("HomeworkAssignment class needs the getLetterGrade() method.", method != null);
		assertTrue("getLetterGrade() method needs to return type: String", method.getReturnType() == String.class);
	}

	@Test
	public void homeworkAssignmentConstructor() {
		Class klass = HomeworkAssignment.class;

		Constructor<HomeworkAssignment> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class);
		assertTrue("You do not have the required constructor(int, String)", constructor != null);
		try {
			HomeworkAssignment homeworkAssignment = constructor.newInstance(100, "T. Tester");
			Method method = SafeReflection.getMethod(klass, "getPossibleMarks");
			assertTrue("Passed 100 into constructor and expected possibleMarks equal 100",
					100 == (int) method.invoke(homeworkAssignment));
			method = SafeReflection.getMethod(klass, "getSubmitterName");
			assertTrue("Passed 'T. Tester' into constructor and expected submitterName equal `T. Tester`",
					"T. Tester".equals((String) method.invoke(homeworkAssignment)));
		} catch (Exception e) {
			fail("Failed to instantiate HomeworkAssignment");
		}
	}

	@Test
	public void homeworkAssignmentLetterGradeTests() {
		Class klass = HomeworkAssignment.class;

		Constructor<HomeworkAssignment> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class);
		assertTrue("You do not have the required constructor(int, String)", constructor != null);
		try {
			HomeworkAssignment homeworkAssignment = constructor.newInstance(100, "T. Tester");
			Method getLetterGrade = SafeReflection.getMethod(klass, "getLetterGrade");
			Method setEarnedMarks = SafeReflection.getMethod(klass, "setEarnedMarks", Integer.TYPE);

			setEarnedMarks.invoke(homeworkAssignment, new Object[] { 91 });
			assertTrue("Expected A for score of 91%", "A".equals((String) getLetterGrade.invoke(homeworkAssignment)));

			setEarnedMarks.invoke(homeworkAssignment, new Object[] { 81 });
			assertTrue("Expected B for score of 81%", "B".equals((String) getLetterGrade.invoke(homeworkAssignment)));

			setEarnedMarks.invoke(homeworkAssignment, new Object[] { 71 });
			assertTrue("Expected C for score of 71%", "C".equals((String) getLetterGrade.invoke(homeworkAssignment)));

			setEarnedMarks.invoke(homeworkAssignment, new Object[] { 61 });
			assertTrue("Expected D for score of 61%", "D".equals((String) getLetterGrade.invoke(homeworkAssignment)));

			setEarnedMarks.invoke(homeworkAssignment, new Object[] { 51 });
			assertTrue("Expected F for score of 51%", "F".equals((String) getLetterGrade.invoke(homeworkAssignment)));
		} catch (Exception e) {
			fail("Failed to instantiate HomeworkAssignment");
		}
	}
}
