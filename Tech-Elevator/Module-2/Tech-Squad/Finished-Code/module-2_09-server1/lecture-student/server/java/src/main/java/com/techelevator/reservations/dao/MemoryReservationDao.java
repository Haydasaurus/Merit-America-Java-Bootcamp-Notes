package com.techelevator.reservations.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;

public class MemoryReservationDao implements ReservationDao {

    private List<Reservation> reservations;
    private HotelDao hotelDao;

    public MemoryReservationDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
        init();
    }

    private void init() {
        LocalDate now = LocalDate.now();
        List<Hotel> hotels = hotelDao.list();
        reservations = new ArrayList<>();

        reservations.add(new Reservation(getMaxIdPlusOne(), hotels.get(0).getId(), "John Smith", now.toString(),
                now.plusDays(3).toString(), 2));
        reservations.add(new Reservation(getMaxIdPlusOne(), hotels.get(0).getId(), "Sam Turner", now.toString(),
                now.plusDays(5).toString(), 4));
        reservations.add(new Reservation(getMaxIdPlusOne(), hotels.get(0).getId(), "Mark Johnson",
                now.plusDays(7).toString(), now.plusDays(10).toString(), 2));
    }

    public List<Reservation> findAll() {
        return reservations;
    }

    @Override
    public List<Reservation> findByHotel(int hotelID) {

        List<Reservation> hotelReservations = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getHotelID() == hotelID) {
                hotelReservations.add(r);
            }
        }

        return hotelReservations;
    }

    @Override
    public Reservation get(int reservationID) {
        for (Reservation res : reservations) {
            if (res.getId() == reservationID) {
                return res;
            }
        }
        return null;
    }

    @Override
    public Reservation create(Reservation reservation, int hotelID) {
        reservation.setId(getMaxIdPlusOne());
        this.reservations.add(reservation);
        return reservation;
    }

    /**
     * finds the max id in the list of reservations and returns it
     *
     * @return int the max id
     */
    private int getMaxID() {
        int maxID = 0;
        for (Reservation r : reservations) {
            if (r.getId() > maxID) {
                maxID = r.getId();
            }
        }
        return maxID;
    }

    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private int getMaxIdPlusOne() {
        return getMaxID() + 1;
    }

}
