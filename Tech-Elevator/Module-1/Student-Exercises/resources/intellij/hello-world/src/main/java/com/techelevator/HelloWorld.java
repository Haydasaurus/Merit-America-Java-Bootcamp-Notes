package com.techelevator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello!");
        System.out.println("Today is " + LocalDate.now());
        System.out.println("The current time is " + LocalTime.now());

    }

}
