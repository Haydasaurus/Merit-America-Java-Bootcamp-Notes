package com.techelevator.dao;

import com.techelevator.exception.LocationNotFoundException;
import com.techelevator.model.Location;

import java.util.List;

public interface LocationDao {

    List<Location> list();

    Location get(int id) throws LocationNotFoundException;

    Location create(Location location);

    Location update(Location location, int id) throws LocationNotFoundException;

    void delete(int id) throws LocationNotFoundException;

}
