package com.techelevator.locations;

import com.techelevator.locations.model.Location;
import com.techelevator.locations.services.ConsoleService;
import com.techelevator.locations.services.LocationService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final LocationService locationService = new LocationService();


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                handleListLocations();
            } else if (menuSelection == 2) {
                handleShowLocationDetails();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
            }
        }
    }

    private void handleListLocations() {
        Location[] locations = locationService.getAll();
        consoleService.printLocations(locations);
    }

    private void handleShowLocationDetails() {
        Location[] locations = locationService.getAll();
        consoleService.printLocationMenu(locations);
        int locationId = consoleService.promptForMenuSelection();
        if (locationId > 0) {
            Location location = locationService.getOne(locationId);
            consoleService.printLocation(location);
        }
    }

}
