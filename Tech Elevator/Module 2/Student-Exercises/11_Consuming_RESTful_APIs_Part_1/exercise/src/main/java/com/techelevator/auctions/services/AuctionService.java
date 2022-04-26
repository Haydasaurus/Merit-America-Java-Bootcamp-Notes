package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        // call api here
        return null;
    }

    public Auction getAuction(int id) {
        // call api here
        return null;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        // call api here
        return null;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        // call api here
        return null;
    }

}
