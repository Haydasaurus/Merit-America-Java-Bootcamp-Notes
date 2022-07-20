package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if(menuSelection == 1) {
                handleListHotels();
            } else if(menuSelection == 2) {
                handleListReservations();
            } else if(menuSelection == 3) {
                handleAddReservation();
            } else if(menuSelection == 4) {
                handleUpdateReservation();
            } else if(menuSelection == 5) {
                handleDeleteReservation();
            }
            else if (menuSelection == 0) {
                continue;
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void handleListHotels() {
        // List all hotels
        Hotel[] hotels = hotelService.listHotels();
        if( hotels != null ){
            consoleService.printHotels(hotels);
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleListReservations() {
        // List Reservations for hotel
        Hotel[] hotels = hotelService.listHotels();
        if( hotels != null ) {
            consoleService.printHotelMenu(hotels);
            int hotelId = consoleService.promptForMenuSelection("Please select a hotel to list reservations for: ");
            if(hotelId > 0) {
                Reservation[] reservations = hotelService.listReservationsByHotel(hotelId);
                if( reservations != null ) {
                    consoleService.printReservations(reservations,hotelId);
                } else {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleAddReservation() {
        // Create new reservation for a given hotel
        Reservation reservationEnteredByUser = consoleService.promptForReservationData();
        Reservation reservationFromApi = hotelService.addReservation(reservationEnteredByUser);
        // if unsuccessful
        if(reservationFromApi == null){
            consoleService.printErrorMessage();
        }
    }

    private void handleUpdateReservation() {
        Reservation[] reservations = hotelService.listReservations();
        if( reservations != null ) {
            consoleService.printReservationMenu(reservations);
            int reservationId =  consoleService.promptForMenuSelection("Please select a reservation to update: ");
            if (reservationId > 0) {
                Reservation existingReservation = hotelService.getReservation(reservationId);
                if (existingReservation != null) {
                    Reservation reservationEnteredByUser = consoleService.promptForReservationData(existingReservation);
                    if (!hotelService.updateReservation(reservationEnteredByUser)) {
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

    private void handleDeleteReservation() {
        Reservation[] reservations = hotelService.listReservations();
        if( reservations != null ) {
            consoleService.printReservationMenu(reservations);
            int reservationId =  consoleService.promptForMenuSelection("Please select a reservation to delete: ");
            if (reservationId > 0) {
                if (!hotelService.deleteReservation(reservationId)) {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

}
