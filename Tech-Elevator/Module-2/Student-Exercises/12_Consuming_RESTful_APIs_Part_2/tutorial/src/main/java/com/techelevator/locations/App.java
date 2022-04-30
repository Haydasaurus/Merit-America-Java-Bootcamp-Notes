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
            } else if (menuSelection == 3) {
                handleAddLocation();
            } else if (menuSelection == 4) {
                handleUpdateLocation();
            } else if (menuSelection == 5) {
                handleDeleteLocation();
            } else if (menuSelection == 0) {
                continue;
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void handleListLocations() {
        Location[] locations = locationService.getAll();
        if (locations != null) {
            consoleService.printLocations(locations);
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleShowLocationDetails() {
        Location[] locations = locationService.getAll();
        if (locations != null) {
            consoleService.printLocationMenu(locations);
            int locationId = consoleService.promptForMenuSelection();
            if (locationId > 0) {
                Location location = locationService.getOne(locationId);
                if (location != null) {
                    consoleService.printLocation(location);
                } else {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleAddLocation() {
        Location locationEnteredByUser = consoleService.promptForLocationData();
        Location locationFromApi = locationService.add(locationEnteredByUser);
        // if unsuccessful
        if (locationFromApi == null) {
            consoleService.printErrorMessage();
        }
    }

    private void handleUpdateLocation() {
        Location[] locations = locationService.getAll();
        if (locations != null) {
            consoleService.printLocationMenu(locations);
            int locationId =  consoleService.promptForMenuSelection();
            if (locationId > 0) {
                Location existingLocation = locationService.getOne(locationId);
                if (existingLocation != null) {
                    Location locationEnteredByUser = consoleService.promptForLocationData(existingLocation);
                    if (!locationService.update(locationEnteredByUser)) {
                        consoleService.printErrorMessage();
                    }
                } else {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleDeleteLocation() {
        Location[] locations = locationService.getAll();
        if (locations != null) {
            consoleService.printLocationMenu(locations);
            int locationId =  consoleService.promptForMenuSelection();
            if (locationId > 0) {
                if (!locationService.delete(locationId)) {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

}
