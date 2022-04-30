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
        System.out.println("3: Add a Location");
        System.out.println("4: Update a Location");
        System.out.println("5: Delete a Location");
        System.out.println("6: Login");
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

    public Location promptForLocationData() {
        return promptForLocationData(null);
    }

    public Location promptForLocationData(Location existingLocation) {
        Location newLocation = null;
        while (newLocation == null) {
            System.out.println("--------------------------------------------");
            System.out.println("Enter location data as a comma separated list containing:");
            System.out.println("name, address, city, state, zip");
            if (existingLocation != null) {
                System.out.println("Location " + existingLocation.getId() + " Data: " + existingLocation.getName() + ", " + existingLocation.getAddress() + ", " + existingLocation.getCity() + ", " + existingLocation.getState() + ", " + existingLocation.getZip());
            } else {
                System.out.println("Example: Memphis Bell, 123 Bell Street, Memphis, TN, 11111");
            }
            System.out.println("--------------------------------------------");
            System.out.println();
            newLocation = makeLocation(scanner.nextLine());
            if (newLocation == null) {
                System.out.println("Invalid entry. Please try again.");
            }
        }
        if (existingLocation != null) {
            newLocation.setId(existingLocation.getId());
        }
        return newLocation;
    }

    private Location makeLocation(String csv) {
        Location location = null;
        String[] parsed = csv.split(",");
        if (parsed.length == 5) {
            location = new Location();
            location.setName(parsed[0].trim());
            location.setAddress(parsed[1].trim());
            location.setCity(parsed[2].trim());
            location.setState(parsed[3].trim());
            location.setZip(parsed[4].trim());
        }
        return location;
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

	public String promptForString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}
}
