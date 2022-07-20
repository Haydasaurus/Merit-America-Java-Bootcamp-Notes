package com.techelevator.reservations.dao;

import java.util.List;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Reservation;

public interface ReservationDao {

    List<Reservation> findAll();

    List<Reservation> findByHotel(int hotelID) throws HotelNotFoundException;

    Reservation get(int reservationID) throws ReservationNotFoundException;

    Reservation create(Reservation reservation, int hotelID) throws HotelNotFoundException;

    Reservation update(Reservation reservation, int id) throws ReservationNotFoundException;

    void delete(int id) throws ReservationNotFoundException;

}