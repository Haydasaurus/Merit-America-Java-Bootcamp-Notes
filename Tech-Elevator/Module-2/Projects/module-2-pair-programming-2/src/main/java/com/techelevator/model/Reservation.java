package com.techelevator.model;

import java.time.LocalDate;

public class Reservation {

    private int reservationId;
    private int siteId;
    private String name;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDate createDate;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", siteId=" + siteId +
                ", name='" + name + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", createDate=" + createDate +
                '}';
    }
}
