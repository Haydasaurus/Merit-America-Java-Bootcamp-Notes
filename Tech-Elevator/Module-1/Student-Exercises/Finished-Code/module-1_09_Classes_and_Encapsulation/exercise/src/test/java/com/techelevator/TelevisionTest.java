package com.techelevator;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelevisionTest {

	@Before
	public void televisionRequiredMembers() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);

		Method method = SafeReflection.getMethod(klass, "isOn");
		assertTrue("Television class needs the isOn() method.", method != null);
		assertTrue("isOn() method needs to return type: boolean", method.getReturnType() == Boolean.TYPE);

		method = SafeReflection.getMethod(klass, "setOn", Boolean.TYPE);
		assertTrue("Television class should not have a setOn(boolean) method", method == null);

		method = SafeReflection.getMethod(klass, "getCurrentChannel");
		assertTrue("Television class needs the getCurrentChannel() method.", method != null);
		assertTrue("getCurrentChannel() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setCurrentChannel", Integer.TYPE);
		assertTrue("Television class should not have a setCurrentChannel(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getCurrentVolume");
		assertTrue("Television class needs the getCurrentVolume() method.", method != null);
		assertTrue("getCurrentVolume() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setCurrentVolume", Integer.TYPE);
		assertTrue("Television class should not have a setCurrentVolume(int) method", method == null);

		method = SafeReflection.getMethod(klass, "turnOn");
		assertTrue("Television class needs the turnOn() method.", method != null);
		assertTrue("turnOn() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "turnOff");
		assertTrue("Television class needs the turnOff() method.", method != null);
		assertTrue("turnOff() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "changeChannel", Integer.TYPE);
		assertTrue("Television class needs the changeChannel(int) method.", method != null);
		assertTrue("changeChannel(int) method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "channelUp");
		assertTrue("Television class needs the channelUp() method.", method != null);
		assertTrue("channelUp() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "channelDown");
		assertTrue("Television class needs the channelDown() method.", method != null);
		assertTrue("channelDown() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "raiseVolume");
		assertTrue("Television class needs the raiseVolume() method.", method != null);
		assertTrue("raiseVolume() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "lowerVolume");
		assertTrue("Television class needs the lowerVolume() method.", method != null);
		assertTrue("lowerVolume() method needs to return type: void", method.getReturnType() == void.class);
	}

	@Test
	public void televisionConstructor() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method isOn = SafeReflection.getMethod(klass, "isOn");
			Method getCurrentChannel = SafeReflection.getMethod(klass, "getCurrentChannel");
			Method getCurrentVolume = SafeReflection.getMethod(klass, "getCurrentVolume");
			assertFalse("New TVs should be turned off by default.", (boolean) isOn.invoke(television));
			assertTrue("New TVs should have the current channel set to 3 by default.",
					3 == (int) getCurrentChannel.invoke(television));
			assertTrue("New TVs should have the current volume set to 2 by default.",
					2 == (int) getCurrentVolume.invoke(television));
		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}

	@Test
	public void televisionTurnOnOffTests() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method isOn = SafeReflection.getMethod(klass, "isOn");
			Method turnOn = SafeReflection.getMethod(klass, "turnOn");
			Method turnOff = SafeReflection.getMethod(klass, "turnOff");
			Method getCurrentChannel = SafeReflection.getMethod(klass, "getCurrentChannel");
			Method getCurrentVolume = SafeReflection.getMethod(klass, "getCurrentVolume");

			turnOn.invoke(television);
			assertTrue("The TV was turned on. IsOn should now be true.", (boolean) isOn.invoke(television));
			assertTrue("The TV was turned on. CurrentChannel should now be 3.",
					3 == (int) getCurrentChannel.invoke(television));
			assertTrue("The TV was turned on. current volume should now be 2.",
					2 == (int) getCurrentVolume.invoke(television));

			turnOff.invoke(television);
			assertFalse("The TV was turned off. IsOn should now be false.", (boolean) isOn.invoke(television));
		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}

	@Test
	public void televisionChangeChannelTests() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method turnOn = SafeReflection.getMethod(klass, "turnOn");
			Method changeChannel = SafeReflection.getMethod(klass, "changeChannel", Integer.TYPE);
			Method getCurrentChannel = SafeReflection.getMethod(klass, "getCurrentChannel");

			changeChannel.invoke(television, new Object[] { 5 });
			assertTrue("The TV was not turned on. CurrentChannel should not have changed.",
					3 == (int) getCurrentChannel.invoke(television));

			turnOn.invoke(television);
			changeChannel.invoke(television, new Object[] { 5 });
			assertTrue("The TV is turned on. The Channel was Changed to 5. CurrentChannel should now be 5.",
					5 == (int) getCurrentChannel.invoke(television));
		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}

	@Test
	public void televisionChannelUpTests() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method isOn = SafeReflection.getMethod(klass, "isOn");
			Method turnOn = SafeReflection.getMethod(klass, "turnOn");
			Method getCurrentChannel = SafeReflection.getMethod(klass, "getCurrentChannel");
			Method channelUp = SafeReflection.getMethod(klass, "channelUp");

			channelUp.invoke(television);
			assertTrue("ChannelUp should only change if the TV has been turned on.",
					3 == (int) getCurrentChannel.invoke(television));

			turnOn.invoke(television);
			channelUp.invoke(television);
			assertTrue("ChannelUp should have incremented CurrentChannel by 1.",
					4 == (int) getCurrentChannel.invoke(television));
		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}

	@Test
	public void televisionChannelUpPast18Tests() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method turnOn = SafeReflection.getMethod(klass, "turnOn");
			Method changeChannel = SafeReflection.getMethod(klass, "changeChannel", Integer.TYPE);
			Method getCurrentChannel = SafeReflection.getMethod(klass, "getCurrentChannel");
			Method channelUp = SafeReflection.getMethod(klass, "channelUp");

			turnOn.invoke(television);
			changeChannel.invoke(television, new Object[] { 17 });

			channelUp.invoke(television);
			assertTrue("channelUp should have incremented CurrentChannel by 1.",
					18 == (int) getCurrentChannel.invoke(television));

			channelUp.invoke(television);
			assertTrue("channelUp should not let CurrentChannel go past 18. Reset to 3.",
					3 == (int) getCurrentChannel.invoke(television));

		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}

	@Test
	public void televisionChannelDownTests() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method turnOn = SafeReflection.getMethod(klass, "turnOn");
			Method changeChannel = SafeReflection.getMethod(klass, "changeChannel", Integer.TYPE);
			Method getCurrentChannel = SafeReflection.getMethod(klass, "getCurrentChannel");
			Method channelDown = SafeReflection.getMethod(klass, "channelDown");

			channelDown.invoke(television);
			assertTrue("channelDown should only change if the TV has been turned on.",
					3 == (int) getCurrentChannel.invoke(television));

			turnOn.invoke(television);
			changeChannel.invoke(television, new Object[] { 5 });
			channelDown.invoke(television);
			assertTrue("channelDown should have decremented CurrentChannel by 1.",
					4 == (int) getCurrentChannel.invoke(television));
		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}

	@Test
	public void televisionChannelDownPast3Tests() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method turnOn = SafeReflection.getMethod(klass, "turnOn");
			Method changeChannel = SafeReflection.getMethod(klass, "changeChannel", Integer.TYPE);
			Method getCurrentChannel = SafeReflection.getMethod(klass, "getCurrentChannel");
			Method channelDown = SafeReflection.getMethod(klass, "channelDown");

			turnOn.invoke(television);
			changeChannel.invoke(television, new Object[] { 4 });

			channelDown.invoke(television);
			assertTrue("channelUp should have decremented CurrentChannel by 1.",
					3 == (int) getCurrentChannel.invoke(television));

			channelDown.invoke(television);
			assertTrue("channelDown should not let CurrentChannel go past 3. Reset to 18.",
					18 == (int) getCurrentChannel.invoke(television));

		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}

	@Test
	public void Television_VolumeTests() {
		Class klass = Television.class;

		Constructor<Television> constructor = SafeReflection.getConstructor(klass);
		assertTrue("You do not have the required constructor()", constructor != null);
		try {
			Television television = constructor.newInstance();
			Method turnOn = SafeReflection.getMethod(klass, "turnOn");
			Method getCurrentVolume = SafeReflection.getMethod(klass, "getCurrentVolume");
			Method raiseVolume = SafeReflection.getMethod(klass, "raiseVolume");
			Method lowerVolume = SafeReflection.getMethod(klass, "lowerVolume");

			raiseVolume.invoke(television);
			assertTrue("Current volume should only be increased if the TV is on.",
					2 == (int) getCurrentVolume.invoke(television));

			turnOn.invoke(television);
			raiseVolume.invoke(television);
			assertTrue("raiseVolume should have incremented current volume by 1.",
					3 == (int) getCurrentVolume.invoke(television));

			lowerVolume.invoke(television);
			assertTrue("LowerVolume should have decremented current volume by 1.",
					2 == (int) getCurrentVolume.invoke(television));

			lowerVolume.invoke(television);
			assertTrue("LowerVolume should have decremented current volume by 1.",
					1 == (int) getCurrentVolume.invoke(television));

			lowerVolume.invoke(television);
			assertTrue("LowerVolume should have decremented current volume by 0.",
					0 == (int) getCurrentVolume.invoke(television));

			lowerVolume.invoke(television);
			assertTrue("LowerVolume should not let current volume go below 0.",
					0 == (int) getCurrentVolume.invoke(television));
		} catch (Exception e) {
			fail("Failed to instantiate Television");
		}
	}
}
