package com.techelevator;

public class Examples {

    public static void main(String[] args) {

        //create and set myClock (as GrandfatherClock) to 00:00:00, tick 2 times
        GrandfatherClock myClock = new GrandfatherClock();
        myClock.tick(); //outputs "tock"
        myClock.tick(); //outputs "tick"
        String currentTime = myClock.getCurrentTime();

        System.out.println(currentTime); //outputs "00:00:02"
        System.out.println();

        //set myClock to 10:30:10 and tick 2 times
        int hour = 10;
        int minute = 30;
        int second = 10;

        myClock.setHour(hour);
        myClock.setMinute(minute);
        myClock.setSecond(second); // set myClock to 10:30:10

        myClock.tick(); //outputs "tock"
        myClock.tick(); //outputs "tick"
        currentTime = myClock.getCurrentTime();

        System.out.println(currentTime); //outputs "10:30:12"
        System.out.println();

        //create and set myClock1 (as CuckooClock) to 10:59:59, tick 2 times
        CuckooClock myClock1 = new CuckooClock(10, 59,59);

        myClock1.tick(); //outputs "cuckoo cuckoo" for full hour
        myClock1.tick(); //outputs nothing
        currentTime = myClock1.getCurrentTime();

        System.out.println(currentTime); //outputs "11:00:01"
        System.out.println();

        //as previous example, treating CuckooClock as plain Clock
        Clock myClock2 = new CuckooClock(10, 59, 59);

        myClock2.tick(); //outputs "cuckoo cuckoo" for full hour
        myClock2.tick(); //outputs nothing
        myClock2.tick(); //outputs nothing
        currentTime = myClock2.getCurrentTime();

        System.out.println(currentTime); //outputs "11:00:02"
        System.out.println();

        //dynamically choose which kind of clock you want
        //create myClock3 as plain Clock then dynamically set to CuckooClock
        Clock myClock3;
        String choice = "cuckoo";
        if(choice.equals("cuckoo")) {
            myClock3 = new CuckooClock();
        } else {
            myClock3 = new GrandfatherClock();
        }

        myClock3.tick(7400); //ticks 7400 times (7400 seconds or 2 hours (7200), 3 minutes(180), 20 seconds)
                                          //outputs "cuckoo cuckoo" 2 times (once for each full hour)
        currentTime = myClock3.getCurrentTime();

        System.out.println(currentTime); // outputs "02:03:20"
        System.out.println();

        //create myClock4 as plain Clock then dynamically set to GrandfatherClock
        Clock myClock4;
        choice = "grandfather";
        if(choice.equals("cuckoo")) {
            myClock4 = new CuckooClock();
        } else {
            myClock4 = new GrandfatherClock();
        }

        myClock4.tick(4); //ticks 4 times (4 seconds) - outputs tock, tick, tock, tick
        currentTime = myClock4.getCurrentTime();

        System.out.println(currentTime); //outputs "00:00:04"
        System.out.println();

    }

}
