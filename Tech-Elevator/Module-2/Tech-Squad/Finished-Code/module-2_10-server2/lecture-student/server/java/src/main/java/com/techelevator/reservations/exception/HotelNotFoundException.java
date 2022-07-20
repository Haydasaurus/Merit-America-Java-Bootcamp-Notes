package com.techelevator.reservations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Hotel not found.")
public class HotelNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public HotelNotFoundException() {
        super("Hotel not found.");
    }
}
