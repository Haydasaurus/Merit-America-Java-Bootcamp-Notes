package com.techelevator.locations.services;

import com.techelevator.locations.model.Location;

import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection() {
        int menuSelection;
        System.out.print("Please choose an option: ");
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("----Meetup Locations Menu----");
        System.out.println("1: List Locations");
        System.out.println("2: Show Location Details");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printLocationMenu(Location[] locations) {
        printLocations(locations);
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printLocation(Location location) {
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("Location Details");
        System.out.println("--------------------------------------------");
        if (location == null) {
            System.out.println("No location to print");
        } else {
            System.out.println("Id: " + location.getId());
            System.out.println("Name: " + location.getName());
            System.out.println("Address: " + location.getAddress());
            System.out.println("City: " + location.getCity());
            System.out.println("State: " + location.getState());
            System.out.println("Zip: " + location.getZip());
        }
    }

    public void printLocations(Location[] locations) {
        System.out.println("--------------------------------------------");
        System.out.println("Locations");
        System.out.println("--------------------------------------------");
        for (Location location : locations) {
            System.out.println(location.getId() + ": " + location.getName());
        }
    }

}
