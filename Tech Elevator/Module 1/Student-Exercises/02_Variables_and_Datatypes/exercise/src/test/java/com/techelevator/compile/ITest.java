package com.techelevator.compile;

public interface ITest {

    default boolean getBooleanResult() { return false; }

    default byte getByteResult() { return 0;}

    default char getCharResult() { return 0;}

    default double getDoubleResult() { return 0; }

    default float getFloatResult() { return 0; }

    default int getIntResult() { return 0; }

    default  long getLongResult() { return 0; }

    default String getStringResult() { return ""; }

}