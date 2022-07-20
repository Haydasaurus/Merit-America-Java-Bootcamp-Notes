package com.techelevator.hotels.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
    @JsonProperty("hotelID")
    private int hotelId;
    private String title;
    private String review;
    private String author;
    private int stars;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Review Details" +
                "\n--------------------------------------------" +
                "\n Hotel ID: " + hotelId +
                "\n Title: " + title +
                "\n Review: " + review +
                "\n Author: " + author +
                "\n Stars: " + stars;
    }
}
