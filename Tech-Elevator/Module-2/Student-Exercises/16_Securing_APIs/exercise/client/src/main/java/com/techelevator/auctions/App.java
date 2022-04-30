package com.techelevator.auctions;

import com.techelevator.auctions.model.Auction;
import com.techelevator.auctions.services.AuctionService;
import com.techelevator.auctions.services.AuthenticationService;
import com.techelevator.auctions.services.ConsoleService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final AuctionService auctionService = new AuctionService();
    private final AuthenticationService authenticationService = new AuthenticationService();

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
                handleListAllAuctions();
            } else if (menuSelection == 2) {
                handleShowAuctionDetails();
            } else if (menuSelection == 3) {
                handleFindAuctionsByTitle();
            } else if (menuSelection == 4) {
                handleFindAuctionsByPrice();
            } else if (menuSelection == 5) {
                handleAddAuction();
            } else if (menuSelection == 6) {
                handleUpdateAuction();
            } else if (menuSelection == 7) {
                handleDeleteAuction();
            } else if (menuSelection == 8) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
            }
        }
    }

    private void handleListAllAuctions() {
        Auction[] auctions = auctionService.getAllAuctions();
        printAuctionsOrError(auctions);
    }

    private void printAuctionsOrError(Auction[] auctions) {
        if (auctions != null) {
            consoleService.printAuctions(auctions);
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleShowAuctionDetails() {
        Auction[] auctions = auctionService.getAllAuctions();
        if (auctions != null) {
            consoleService.printAuctionMenu(auctions);
            int auctionId = consoleService.promptForMenuSelection();
            if (auctionId > 0) {
                Auction auction = auctionService.getAuction(auctionId);
                if (auction != null) {
                    consoleService.printAuction(auction);
                } else {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleFindAuctionsByTitle() {
        String title = consoleService.promptForAuctionTitle();
        if (title != null) {
            Auction[] auctions = auctionService.getAuctionsMatchingTitle(title);
            printAuctionsOrError(auctions);
        }
    }

    private void handleFindAuctionsByPrice() {
        double price = consoleService.promptForAuctionPrice();
        if (price > 0) {
            Auction[] auctions = auctionService.getAuctionsAtOrBelowPrice(price);
            printAuctionsOrError(auctions);
        }
    }

    private void handleAddAuction() {
        Auction auctionEnteredByUser = consoleService.promptForAuctionData();
        Auction auctionFromApi = auctionService.add(auctionEnteredByUser);
        if (auctionFromApi == null) {
            consoleService.printErrorMessage();
        }
    }

    private void handleUpdateAuction() {
        Auction[] auctions = auctionService.getAllAuctions();
        if (auctions != null) {
            consoleService.printAuctionMenu(auctions);
            int auctionId =  consoleService.promptForMenuSelection();
            if (auctionId > 0) {
                Auction existingAuction = auctionService.getAuction(auctionId);
                if (existingAuction != null) {
                    Auction auctionEnteredByUser = consoleService.promptForAuctionData(existingAuction);
                    if (!auctionService.update(auctionEnteredByUser)) {
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

    private void handleDeleteAuction() {
        Auction[] auctions = auctionService.getAllAuctions();
        if (auctions != null) {
            consoleService.printAuctionMenu(auctions);
            int auctionId = consoleService.promptForMenuSelection();
            if (auctionId > 0) {
                if (!auctionService.delete(auctionId)) {
                    consoleService.printErrorMessage();
                }
            }
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        String username = consoleService.promptForString("Username: ");
        String password = consoleService.promptForString("Password: ");
        String token = authenticationService.login(username, password);
        if (token != null) {
            auctionService.setAuthToken(token);
        } else {
            consoleService.printErrorMessage();
        }
    }
}
