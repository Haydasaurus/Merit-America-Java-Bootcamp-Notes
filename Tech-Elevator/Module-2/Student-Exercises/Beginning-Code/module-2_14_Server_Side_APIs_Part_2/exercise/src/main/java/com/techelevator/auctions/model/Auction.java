package com.techelevator.auctions.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Auction {

    private int id;
    private String title;
    private String description;
    private String user;
    private double currentBid;

    public Auction() {
    }

    public Auction(String title, String description, String user, double currentBid) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.currentBid = currentBid;
    }

    public Auction(int id, String title, String description, String user, double currentBid) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.currentBid = currentBid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public String currentBidToString() {
        return id + ": " + title + " | Current Bid: " + currentBid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Auction{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\''
                + ", user='" + user + '\'' + ", currentBid=" + currentBid + '}';
    }
}
