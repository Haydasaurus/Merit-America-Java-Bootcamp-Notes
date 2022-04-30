package com.techelevator;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElevatorTest {

	@Before
	public void elevatorRequiredMembers() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);

		Method method = SafeReflection.getMethod(klass, "getCurrentFloor");
		assertTrue("Elevator class needs the getCurrentFloor() method.", method != null);
		assertTrue("getCurrentFloor() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setCurrentFloor", Integer.TYPE);
		assertTrue("Elevator class should not have a setCurrentFloor(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getNumberOfFloors");
		assertTrue("Elevator class needs the getNumberOfFloors() method.", method != null);
		assertTrue("getNumberOfFloors() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setNumberOfFloors", Integer.TYPE);
		assertTrue("Elevator class should not have a setNumberOfFloors(int) method", method == null);

		method = SafeReflection.getMethod(klass, "isDoorOpen");
		assertTrue("Elevator class needs the isDoorOpen() method.", method != null);
		assertTrue("isDoorOpen() method needs to return type: boolean", method.getReturnType() == Boolean.TYPE);

		method = SafeReflection.getMethod(klass, "setDoorOpen", Integer.TYPE);
		assertTrue("Elevator class should not have a setDoorOpen(boolean) method", method == null);

		method = SafeReflection.getMethod(klass, "openDoor");
		assertTrue("Elevator class needs the openDoor() method.", method != null);
		assertTrue("openDoor() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "closeDoor");
		assertTrue("Elevator class needs the closeDoor() method.", method != null);
		assertTrue("closeDoor() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "goUp", Integer.TYPE);
		assertTrue("Elevator class needs the goUp() method.", method != null);
		assertTrue("goUp() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "goDown", Integer.TYPE);
		assertTrue("Elevator class needs the goDown() method.", method != null);
		assertTrue("goDown() method needs to return type: void", method.getReturnType() == void.class);
	}

	@Test
	public void elevatorConstructor() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);
		try {
			Elevator elevator = constructor.newInstance(3);
			Method getCurrentFloor = SafeReflection.getMethod(klass, "getCurrentFloor");
			Method getNumberOfFloors = SafeReflection.getMethod(klass, "getNumberOfFloors");
			Method isDoorOpen = SafeReflection.getMethod(klass, "isDoorOpen");

			assertTrue("CurrentLevel for new Elevators should return 1.", 1 == (int) getCurrentFloor.invoke(elevator));
			assertTrue("NumberOfLevels should be equal to the argument passed into the Constructor.",
					3 == (int) getNumberOfFloors.invoke(elevator));
			assertFalse("The door should be closed for new elevators.", (boolean) isDoorOpen.invoke(elevator));
		} catch (Exception e) {
			fail("Failed to instantiate Elevator");
		}
	}

	@Test
	public void elevatorOpenDoorTests() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);
		try {
			Elevator elevator = constructor.newInstance(3);
			Method openDoor = SafeReflection.getMethod(klass, "openDoor");
			Method closeDoor = SafeReflection.getMethod(klass, "closeDoor");
			Method isDoorOpen = SafeReflection.getMethod(klass, "isDoorOpen");

			openDoor.invoke(elevator);
			assertTrue("The door should be open after calling OpenDoor.", (boolean) isDoorOpen.invoke(elevator));
			closeDoor.invoke(elevator);
			assertFalse("The door should be closed after calling CloseDoor.", (boolean) isDoorOpen.invoke(elevator));
		} catch (Exception e) {
			fail("Failed to instantiate Elevator");
		}
	}

	@Test
	public void elevatorMoveUpAndDownTests() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);
		try {
			Elevator elevator = constructor.newInstance(3);
			Method openDoor = SafeReflection.getMethod(klass, "openDoor");
			Method closeDoor = SafeReflection.getMethod(klass, "closeDoor");
			Method goUp = SafeReflection.getMethod(klass, "goUp", Integer.TYPE);
			Method goDown = SafeReflection.getMethod(klass, "goDown", Integer.TYPE);
			Method getCurrentFloor = SafeReflection.getMethod(klass, "getCurrentFloor");

			goUp.invoke(elevator, new Object[] { 2 });
			assertTrue("The elevator should go up to the floor that it was directed to.",
					2 == (int) getCurrentFloor.invoke(elevator));

			openDoor.invoke(elevator);
			goUp.invoke(elevator, new Object[] { 3 });
			assertTrue("The elevator should remain on its current floor if the door is open.",
					2 == (int) getCurrentFloor.invoke(elevator));
			closeDoor.invoke(elevator);

			goUp.invoke(elevator, new Object[] { 3 });
			assertTrue("The elevator should go up to the floor that it was directed to.",
					3 == (int) getCurrentFloor.invoke(elevator));

			goUp.invoke(elevator, new Object[] { 4 });
			assertTrue("The elevator should not go past its last floor.", 3 == (int) getCurrentFloor.invoke(elevator));

			goUp.invoke(elevator, new Object[] { 1 });
			assertTrue("The elevator should only go up if the desired floor is greater than the current floor.",
					3 == (int) getCurrentFloor.invoke(elevator));

			goDown.invoke(elevator, new Object[] { 2 });
			assertTrue("The elevator should go down to the floor that it was directed to.",
					2 == (int) getCurrentFloor.invoke(elevator));

			openDoor.invoke(elevator);
			goDown.invoke(elevator, new Object[] { 1 });
			assertTrue("The elevator should remain on its current floor if the door is open.",
					2 == (int) getCurrentFloor.invoke(elevator));
			closeDoor.invoke(elevator);

			goDown.invoke(elevator, new Object[] { 1 });
			assertTrue("The elevator should go down to the floor that it was directed to.",
					1 == (int) getCurrentFloor.invoke(elevator));

			goDown.invoke(elevator, new Object[] { -1 });
			assertTrue("The elevator should not go below floor 1.", 1 == (int) getCurrentFloor.invoke(elevator));

			goDown.invoke(elevator, new Object[] { 3 });
			assertTrue("The elevator should only go down if the desired floor is less than the current floor.",
					1 == (int) getCurrentFloor.invoke(elevator));

		} catch (Exception e) {
			fail("Failed to instantiate Elevator");
		}
	}
}
