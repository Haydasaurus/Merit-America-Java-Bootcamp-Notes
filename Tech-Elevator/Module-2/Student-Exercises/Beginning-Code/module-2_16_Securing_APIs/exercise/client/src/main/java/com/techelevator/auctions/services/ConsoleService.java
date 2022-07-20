package com.techelevator.auctions.services;

import com.techelevator.auctions.model.Auction;

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
        System.out.println("----Online Auctions Menu----");
        System.out.println("1: List all auctions");
        System.out.println("2: List details for specific auction");
        System.out.println("3: Find auctions with a specific term in the title");
        System.out.println("4: Find auctions below a specified price");
        System.out.println("5: Create a new auction");
        System.out.println("6: Modify an auction");
        System.out.println("7: Delete an auction");
        System.out.println("8: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printAuctionMenu(Auction[] auctions) {
        printAuctions(auctions);
        System.out.println("0: Exit");
        System.out.println();
    }

    public String promptForAuctionTitle() {
        System.out.println("--------------------------------------------");
        System.out.print("Enter title to search for: ");
        return scanner.nextLine();
    }

    public double promptForAuctionPrice() {
        double price;
        System.out.println("--------------------------------------------");
        System.out.print("Enter the maximum price to search for: ");
        // Catch invalid input, and set price to 0.0 if it happens.
        try {
            price = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e) {
            price = 0.0;
        }
        return price;
    }

    public void printAuctions(Auction[] auctions) {
        if (auctions != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Auctions");
            System.out.println("--------------------------------------------");
            for (Auction auction : auctions) {
                System.out.println(auction.currentBidToString());
            }
        }
    }

    public void printAuction(Auction auction) {
        System.out.println("--------------------------------------------");
        System.out.println("Auction Details");
        System.out.println("--------------------------------------------");
        if (auction == null) {
            System.out.println("No auction to print");
        } else {
            System.out.println("Id: " + auction.getId());
            System.out.println("Title: " + auction.getTitle());
            System.out.println("Description: " + auction.getDescription());
            System.out.println("User: " + auction.getUser());
            System.out.println("Current Bid: " + auction.getCurrentBid());
        }
    }

    public Auction promptForAuctionData() {
        return promptForAuctionData(null);
    }

    public Auction promptForAuctionData(Auction existingAuction) {
        Auction newAuction = null;
        while (newAuction == null) {
            System.out.println("--------------------------------------------");
            System.out.println("Enter auction data as a comma separated list containing:");
            System.out.println("title, description, user, current bid price (without dollar sign)");
            if (existingAuction != null) {
                System.out.println("Auction " + existingAuction.getId() + " Data: " + existingAuction.getTitle() +
                        ", " + existingAuction.getDescription() + ", " + existingAuction.getUser() + ", " +
                        existingAuction.getCurrentBid());
            } else {
                System.out.println("Example: Mad-dog Sneakers, Soles check. Laces check., Cierra_Pagac, 125.23");
            }
            System.out.println("--------------------------------------------");
            newAuction = makeAuction(scanner.nextLine());
            if (newAuction == null) {
                System.out.println("Invalid entry. Please try again.");
            }
        }
        if (existingAuction != null) {
            newAuction.setId(existingAuction.getId());
        }
        return newAuction;
    }

    private Auction makeAuction(String csv) {
        Auction auction = null;
        String[] parsed = csv.split(",");
        if (parsed.length == 4) {
            try {
                auction = new Auction();
                auction.setTitle(parsed[0].trim());
                auction.setDescription(parsed[1].trim());
                auction.setUser(parsed[2].trim());
                auction.setCurrentBid(Double.parseDouble(parsed[3].trim()));
            } catch (NumberFormatException e) {
                auction = null;
            }
        }
        return auction;
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

}
