package com.techelevator;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USCitiesAndParksCLI {

    private final Scanner userInput = new Scanner(System.in);

    private final StateDao stateDao;
    private final CityDao cityDao;
    private final ParkDao parkDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        USCitiesAndParksCLI application = new USCitiesAndParksCLI(dataSource);
        application.run();
    }

    public USCitiesAndParksCLI(DataSource dataSource) {
        stateDao = new JdbcStateDao(dataSource);
        cityDao = new JdbcCityDao(dataSource);
        parkDao = new JdbcParkDao(dataSource);
    }

    private void run() {
        displayBanner();
        boolean running = true;
        while (running) {
            displayMenu();
            int selection = promptForInt("Please select an option: ");
            if (selection == 1) {
                manageCityInfo();
            } else if (selection == 2) {
                addNewCity();
            } else if (selection == 3) {
                manageParkInfo();
            } else if (selection == 4) {
                addNewPark();
            } else if (selection == 5) {
                running = false;
            } else {
                displayError("Invalid option selected.");
            }
        }
    }

    private void manageCityInfo() {
        City city = promptForCity();
        System.out.println();
        displayCity(city);
        String response = promptForString("(U)pdate this city, (D)elete this city, or press Enter to continue: ");
        if (response.equalsIgnoreCase("U")) {
            updateCity(city);
        } else if (response.equalsIgnoreCase("D")) {
            deleteCity(city);
        }
    }

    private void updateCity(City cityToUpdate) {
        String newName = promptForString("New name (enter to leave unchanged): ");
        if (!newName.isBlank()) {
            cityToUpdate.setCityName(newName);
        }
        int newPopulation = promptForInt("New population (enter to leave unchanged): ");
        if (newPopulation >= 0) {
            cityToUpdate.setPopulation(newPopulation);
        }
        double newArea = promptForDouble("New area (enter to leave unchanged): ");
        if (newArea >= 0) {
            cityToUpdate.setArea(newArea);
        }

        cityDao.updateCity(cityToUpdate);
        System.out.format("\nUpdated %s\n\n", cityToUpdate);
    }

    private void deleteCity(City cityToDelete) {
        State state = stateDao.getStateByCapital(cityToDelete.getCityId());
        if (state != null) {
            displayError("Cannot delete capital of " + state.getStateName());
        } else {
            cityDao.deleteCity(cityToDelete.getCityId());
            System.out.format("\nDeleted %s\n\n", cityToDelete);
        }
    }

    private void addNewCity() {
        City newCity = promptForNewCityData();
        newCity = cityDao.createCity(newCity);
        System.out.println("\nAdded the following city to the database:");
        displayCity(newCity);
    }

    private void manageParkInfo() {
        Park park = promptForPark();
        System.out.println();
        displayPark(park);
        String response = promptForString("(U)pdate this park, (D)elete this park, or press Enter to continue: ");
        if (response.equalsIgnoreCase("U")) {
            updatePark(park);
        } else if (response.equalsIgnoreCase("D")) {
            deletePark(park);
        }
    }

    private void updatePark(Park parkToUpdate) {
        String newName = promptForString("New name (enter to leave unchanged): ");
        if (!newName.isBlank()) {
            parkToUpdate.setParkName(newName);
        }
        LocalDate newDateEstablished = promptForDate("New date established (YYYY-MM-DD or enter to leave unchanged): ");
        if (newDateEstablished != null) {
            parkToUpdate.setDateEstablished(newDateEstablished);
        }
        double newArea = promptForDouble("New area (enter to leave unchanged): ");
        if (newArea >= 0) {
            parkToUpdate.setArea(newArea);
        }
        String reply = promptForString("Does the park offer camping (Y/N or enter to leave unchanged)? ");
        if (reply.equalsIgnoreCase("Y")) {
            parkToUpdate.setHasCamping(true);
        } else if (reply.equalsIgnoreCase("N")) {
            parkToUpdate.setHasCamping(false);
        }

        parkDao.updatePark(parkToUpdate);
        System.out.format("\nUpdated %s\n\n", parkToUpdate);
    }

    private void deletePark(Park parkToDelete) {
        parkDao.deletePark(parkToDelete.getParkId());
        System.out.format("\nDeleted %s\n\n", parkToDelete);
    }

    private void addNewPark() {
        Park newPark = promptForNewParkData();

        newPark = parkDao.createPark(newPark);
        System.out.println("\nAdded the following park to the database:");
        displayPark(newPark);

        String stateAbbrs = "";
        while (stateAbbrs.isBlank()) {
            stateAbbrs = promptForString("List of abbreviations for the states this park is located in (separated by commas): ");
        }
        stateAbbrs = stateAbbrs.trim().toUpperCase();
        for (String stateAbbr : stateAbbrs.split(", *")) {
            State state = stateDao.getState(stateAbbr);
            if (state != null) {
                parkDao.addParkToState(newPark.getParkId(), state.getStateAbbreviation());
                System.out.format("Added %s to %s.\n", newPark.getParkName(), state.getStateName());
            }
        }
        System.out.println();
    }

    private void displayBanner() {
        System.out.println("-----------------------------------------");
        System.out.println("|  US Cities and Parks Data Management  |");
        System.out.println("-----------------------------------------");
    }

    private void displayMenu() {
        System.out.println("1. View or modify city information");
        System.out.println("2. Add new city");
        System.out.println("3. View or modify park information");
        System.out.println("4. Add new park");
        System.out.println("5. Exit");
    }

    private void displayError(String message) {
        System.out.println();
        System.out.println("***" + message + "***");
        System.out.println();
    }

    private void displayCity(City city) {
        System.out.println(city);
        System.out.format("Population: %d Area: %.1f sq. km\n\n", city.getPopulation(), city.getArea());
    }

    private void displayPark(Park park) {
        System.out.println(park);
        System.out.format("Established: %s Area: %.1f sq. km\n", park.getDateEstablished(), park.getArea());
        System.out.format("This park %s camping.\n\n", park.getHasCamping()? "offers" : "does not offer");
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return userInput.nextLine();
    }

    private int promptForInt(String prompt) {
        return (int) promptForDouble(prompt);
    }

    private double promptForDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            try {
                return Double.parseDouble(response);
            }  catch (NumberFormatException e) {
                if (response.isBlank()) {
                    return -1; //Assumes negative numbers are never valid entries.
                } else {
                    displayError("Numbers only, please.");
                }
            }
        }
    }

    private LocalDate promptForDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            try {
                return LocalDate.parse(response);
            }  catch (DateTimeParseException e) {
                if (response.isBlank()) {
                    return null;
                } else {
                    displayError("Please format as YYYY-MM-DD.");
                }
            }
        }
    }

    private State promptForState() {
        while (true) {
            System.out.print("Please enter a state abbreviation (enter ? to list state abbreviations): ");
            String response = userInput.nextLine();
            if (response.equals("?")) {
                for (State state : stateDao.getStates()) {
                    System.out.println(state.getStateAbbreviation() + "   " + state.getStateName());
                }
            } else {
                State result = stateDao.getState(response.toUpperCase());
                if (result == null) {
                    displayError("Invalid state abbreviation.");
                } else {
                    return result;
                }
            }
        }
    }

    private City promptForCity() {
        List<City> cities = new ArrayList<>();
        while (cities.size() == 0) {
            System.out.println("What state is the city in?");
            State state = promptForState();
            cities = cityDao.getCitiesByState(state.getStateAbbreviation());
            if (cities.size() == 0) {
                displayError("No cities in selected state.");
            }
        }
        for (int i = 0; i < cities.size(); i++) {
            System.out.format("%3d. %s\n", i + 1, cities.get(i).getCityName());
        }
        while (true) {
            try {
                int selection = promptForInt("Please select a city: ");
                return cities.get(selection - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                displayError("Invalid selection.");
            }
        }
    }

    private City promptForNewCityData() {
        City city = new City();

        String name = "";
        while (name.isBlank()) {
            name = promptForString("City name: ");
        }
        city.setCityName(name);
        int population = -1;
        while (population < 0) {
            population = promptForInt("Population: ");
        }
        city.setPopulation(population);
        double area = -1;
        while (area < 0) {
            area = promptForDouble("Area (in sq. km.): ");
        }
        city.setArea(area);

        System.out.println("What state is this city in?");
        State state = promptForState();
        city.setStateAbbreviation(state.getStateAbbreviation());

        return city;
    }

    private Park promptForPark() {
        List<Park> parks = new ArrayList<>();
        while (parks.size() == 0) {
            System.out.println("What state is the park in?");
            State state = promptForState();
            parks = parkDao.getParksByState(state.getStateAbbreviation());
            if (parks.size() == 0) {
                displayError("No parks in selected state.");
            }
        }
        for (int i = 0; i < parks.size(); i++) {
            System.out.format("%3d. %s\n", i + 1, parks.get(i).getParkName());
        }
        while (true) {
            try {
                int selection = promptForInt("Please select a park: ");
                return parks.get(selection - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                displayError("Invalid selection.");
            }
        }
    }

    private Park promptForNewParkData() {
        Park park = new Park();

        String name = "";
        while (name.isBlank()) {
            name = promptForString("Park name: ");
        }
        park.setParkName(name);
        LocalDate dateEstablished = null;
        while (dateEstablished == null) {
            dateEstablished = promptForDate("Date established (YYYY-MM-DD): ");
        }
        park.setDateEstablished(dateEstablished);
        double area = -1;
        while (area < 0) {
            area = promptForDouble("Area (in sq. km.): ");
        }
        park.setArea(area);
        String reply = promptForString("Does this park offer camping (Y/N)? ");
        park.setHasCamping(reply.equalsIgnoreCase("Y"));

        return park;
    }


}
