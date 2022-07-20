package com.techelevator.auctions.dao;

import com.techelevator.auctions.model.Auction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryAuctionDao implements AuctionDao {

    public static List<Auction> auctions = new ArrayList<>();

    public MemoryAuctionDao() {
        if (auctions.size() == 0) {
            setAuctions();
        }
    }

    @Override
    public List<Auction> list() {
        return auctions;
    }

    @Override
    public Auction get(int id) {
        for(Auction auction : auctions) {
            if(auction.getId() == id) {
                return auction;
            }
        }
        return null;
    }

    @Override
    public Auction create(Auction auction) {
        auction.setId(getMaxIdPlusOne());
        auctions.add(auction);
        return auction;
    }

    @Override
    public List<Auction> searchByTitle(String searchTerm) {
        List<Auction> matchTitles = new ArrayList<>();
        if (!searchTerm.isEmpty()) {
            for (Auction auction : auctions) {
                if (auction.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                    matchTitles.add(auction);
                }
            }
        }
        return matchTitles;
    }

    @Override
    public List<Auction> searchByPrice(double maxPrice) {
        List<Auction> matchPrices = new ArrayList<>();
        for(Auction auction : auctions) {
            if(auction.getCurrentBid() <= maxPrice) {
                matchPrices.add(auction);
            }
        }
        return matchPrices;
    }

    @Override
    public List<Auction> searchByTitleAndPrice(String title, double currentBid) {
        List<Auction> auctionsByTitle = searchByTitle(title);
        List<Auction> auctionsByPrice = searchByPrice(currentBid);
        return auctionsByTitle.stream().filter(auctionsByPrice::contains).collect(Collectors.toList());
    }

    private void setAuctions() {
        auctions.add(new Auction(1,
                "Bell Computer Monitor",
                "4K LCD monitor from Bell Computers, HDMI & DisplayPort",
                "Queenie34",
                100.39));
        auctions.add(new Auction(2,
                "Pineapple Smart Watch",
                "Pears with Pineapple ePhone",
                "Miller.Fahey",
                377.44));
        auctions.add(new Auction(3,
                "Mad-dog Sneakers",
                "Soles check. Laces check.",
                "Cierra_Pagac",
                125.23));
        auctions.add(new Auction(4,
                "Annie Sunglasses",
                "Keep the sun from blinding you",
                "Sallie_Kerluke4",
                69.67));
        auctions.add(new Auction(5,
                "Byson Vacuum",
                "Clean your house with a spherical vacuum",
                "Lisette_Crist",
                287.73));
        auctions.add(new Auction(6,
                "Fony Headphones",
                "Listen to music, movies, games and not bother people around you",
                "Chester67",
                267.38));
        auctions.add(new Auction(7,
                "Molex Gold Watch",
                "Definitely not fake gold watch",
                "Stuart27",
                188.39));
    }

    /**
     * finds the max id in the list of auctions and returns it
     *
     * @return int the max id
     */
    private int getMaxID() {
        int maxID = 0;
        for (Auction auction : auctions) {
            if (auction.getId() > maxID) {
                maxID = auction.getId();
            }
        }
        return maxID;
    }

    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private int getMaxIdPlusOne() {
        return getMaxID() + 1;
    }

}
