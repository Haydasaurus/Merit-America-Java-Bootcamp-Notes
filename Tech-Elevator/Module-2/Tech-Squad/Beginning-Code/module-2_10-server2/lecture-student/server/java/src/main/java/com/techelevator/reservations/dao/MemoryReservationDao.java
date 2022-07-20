package com.techelevator.reservations.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;

@Component
public class MemoryReservationDao implements ReservationDao {

    private List<Reservation> reservations = new ArrayList<>();
    private HotelDao hotelDao;

    public MemoryReservationDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
        initializeReservationData();
    }

    public List<Reservation> findAll() {
        return Collections.unmodifiableList(reservations);
    }

    @Override
    public List<Reservation> findByHotel(int hotelID) throws HotelNotFoundException {
        List<Hotel> hotels = hotelDao.list();
        boolean hotelExists = false;
        for (Hotel hotel : hotels) {
            if (hotel.getId() == hotelID) {
                hotelExists = true;
                break;
            }
        }

        if (!hotelExists) {
            throw new HotelNotFoundException();
        }

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
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation, int id) throws ReservationNotFoundException {
        Reservation result = reservation;
        boolean finished = false;

        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == id) {
                if (result.getId() == 0) {
                    result.setId(id);
                }
                reservations.set(i, result);
                finished = true;
                break;
            }
        }
        if (!finished) {
            throw new ReservationNotFoundException();
        }

        return result;
    }

    @Override
    public void delete(int id) throws ReservationNotFoundException {
        boolean found = false;
        // avoid concurrent modification exception using iterator
        for (Iterator<Reservation> iterator = reservations.iterator(); iterator.hasNext();) {
            Reservation reservation = iterator.next();
            if (reservation.getId() == id) {
                iterator.remove();
                found = true;
            }
        }
        if (!found) {
            throw new ReservationNotFoundException();
        }
    }

    private void initializeReservationData() {
        LocalDate now = LocalDate.now();
        List<Hotel> hotels = hotelDao.list();

        reservations.add(new Reservation(getMaxIdPlusOne(),
                hotels.get(0).getId(),
                "John Smith",
                now.toString(),
                now.plusDays(3).toString(),
                2));
        reservations.add(new Reservation(getMaxIdPlusOne(),
                hotels.get(0).getId(),
                "Sam Turner",
                now.toString(),
                now.plusDays(5).toString(),
                4));
        reservations.add(new Reservation(getMaxIdPlusOne(),
                hotels.get(0).getId(),
                "Mark Johnson",
                now.plusDays(7).toString(),
                now.plusDays(10).toString(),
                2));
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
