package com.techelevator.locations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Location not found.")
public class LocationNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public LocationNotFoundException() {
        super("Location not found");
    }
}
