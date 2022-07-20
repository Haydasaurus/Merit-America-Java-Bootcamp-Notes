package com.techelevator.auctions.dao;

import com.techelevator.auctions.exception.AuctionNotFoundException;
import com.techelevator.auctions.model.Auction;

import java.util.List;

public interface AuctionDao {

    List<Auction> list();

    Auction get(int id) throws AuctionNotFoundException;

    Auction create(Auction auction);

    List<Auction> searchByTitle(String title_like);

    List<Auction> searchByPrice(double currentBid_lte);

    Auction update(Auction auction, int id) throws AuctionNotFoundException;

    void delete(int id) throws AuctionNotFoundException;
}
