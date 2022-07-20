package com.techelevator.reservations.dao;

import java.util.List;
import com.techelevator.reservations.model.Reservation;

public interface ReservationDao {

    List<Reservation> findAll();

    List<Reservation> findByHotel(int hotelID);

    Reservation get(int reservationID);

    Reservation create(Reservation reservation, int hotelID);

}
