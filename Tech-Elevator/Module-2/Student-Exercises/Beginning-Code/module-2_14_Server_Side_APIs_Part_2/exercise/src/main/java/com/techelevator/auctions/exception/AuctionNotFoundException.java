package com.techelevator.auctions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Auction Not Found")
public class AuctionNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public AuctionNotFoundException(){
        super("Auction Not Found");
    }
}
