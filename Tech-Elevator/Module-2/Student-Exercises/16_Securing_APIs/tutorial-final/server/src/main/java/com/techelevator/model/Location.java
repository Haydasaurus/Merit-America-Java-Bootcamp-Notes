package com.techelevator.model;

import javax.validation.constraints.NotBlank;

public class Location {

    private int id;
    @NotBlank(message = "The field name is required.")
    private String name;
    @NotBlank(message = "The field address is required.")
    private String address;
    @NotBlank(message = "The field city is required.")
    private String city;
    @NotBlank(message = "The field state is required.")
    private String state;
    @NotBlank(message = "The field zip is required.")
    private String zip;

    public Location() {
    }

    public Location(int id, String name, String address, String city, String state, String zip) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", name=" + name + "]";
    }
}
