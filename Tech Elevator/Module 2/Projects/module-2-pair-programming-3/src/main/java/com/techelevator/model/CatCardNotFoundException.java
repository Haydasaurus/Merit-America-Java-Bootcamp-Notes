package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatCardNotFoundException extends RuntimeException {

    public CatCardNotFoundException() {
        super("CatCard not found");
    }
}
