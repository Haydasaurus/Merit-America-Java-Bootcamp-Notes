package com.techelevator.locations.services;

import com.techelevator.locations.model.Location;
import org.springframework.web.client.RestTemplate;

public class LocationService {

    private static final String API_BASE_URL = "http://localhost:3000/locations/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Location[] getAll() {
        return restTemplate.getForObject(API_BASE_URL, Location[].class);
    }

    public Location getOne(int id) {
        return restTemplate.getForObject(API_BASE_URL + id, Location.class);
    }

}
