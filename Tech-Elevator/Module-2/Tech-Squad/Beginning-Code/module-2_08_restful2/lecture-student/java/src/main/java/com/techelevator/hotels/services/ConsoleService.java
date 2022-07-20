package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;

import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("----Hotels Main Menu----");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reservations for Hotel");
        System.out.println("3: Create new Reservation for Hotel");
        System.out.println("4: Update existing Reservation for Hotel");
        System.out.println("5: Delete Reservation");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printHotelMenu(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        System.out.println("0. Exit");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
        System.out.println();
    }

    public void printReservationMenu(Reservation[] reservations) {
        System.out.println("--------------------------------------------");
        System.out.println("Reservations");
        System.out.println("--------------------------------------------");
        System.out.println("0. Exit");
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
        System.out.println();
    }

    public void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    public void printReservations(Reservation[] reservations, int hotelId) {
        String msg = hotelId == -1 ? "All Reservations" : "Reservations for hotel: " + hotelId;

        System.out.println("--------------------------------------------");
        System.out.println(msg);
        System.out.println("--------------------------------------------");
        if (reservations.length != 0) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.toString());
            }
        } else {
            System.out.println("There are no reservations for hotel: " + hotelId);
        }
    }

    public Reservation promptForReservationData() {
        return promptForReservationData(null);
    }

    public Reservation promptForReservationData(Reservation existingReservation) {
        Reservation newReservation = null;
        while (newReservation == null) {
            System.out.println("--------------------------------------------");
            System.out.println("Enter reservation data as a comma separated list containing:");
            System.out.println("Hotel ID, Full Name, Checkin Date, Checkout Date, Number of Guests");
            if (existingReservation != null) {
                System.out.println(existingReservation);
            } else {
                System.out.println("Example: 1, John Smith, 10/10/2020, 10/14/2020, 2");
            }
            System.out.println("--------------------------------------------");
            System.out.println();
            newReservation = makeReservation(scanner.nextLine());
            if (newReservation == null) {
                System.out.println("Invalid entry. Please try again.");
            }
        }
        if (existingReservation != null) {
            newReservation.setId(existingReservation.getId());
        }
        return newReservation;
    }

    private Reservation makeReservation(String csv) {
        Reservation reservation = null;
        String[] parsed = csv.split(",");
        if (parsed.length == 5) {
            try {
                reservation = new Reservation();
                reservation.setHotelId(Integer.parseInt(parsed[0].trim()));
                reservation.setFullName(parsed[1].trim());
                reservation.setCheckinDate(parsed[2].trim());
                reservation.setCheckoutDate(parsed[3].trim());
                reservation.setGuests(Integer.parseInt(parsed[4].trim()));
            } catch (NumberFormatException e) {
                reservation = null;
            }
        }
        return reservation;
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

}
