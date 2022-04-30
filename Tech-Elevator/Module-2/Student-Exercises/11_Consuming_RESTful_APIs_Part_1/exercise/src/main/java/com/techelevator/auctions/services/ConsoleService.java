package com.techelevator.auctions.services;

import java.util.Scanner;

import com.techelevator.auctions.model.Auction;

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

}
