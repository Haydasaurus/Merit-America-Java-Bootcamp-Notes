package com.techelevator.dao;

import com.techelevator.model.Park;

import java.util.List;

public interface ParkDao {

    Park getPark(long parkId);

    List<Park> getParksByState(String stateAbbreviation);

    Park createPark(Park park);

    void updatePark(Park park);

    void deletePark(long parkId);

    void addParkToState(long parkId, String stateAbbreviation);

    void removeParkFromState(long parkId, String stateAbbreviation);
}
