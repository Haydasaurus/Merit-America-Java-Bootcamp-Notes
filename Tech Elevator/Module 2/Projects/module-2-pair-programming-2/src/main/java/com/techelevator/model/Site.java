package com.techelevator.model;

public class Site {

    private int siteId;
    private int campgroundId;
    private int siteNumber;
    private int maxOccupancy;
    private boolean accessible;
    private int maxRvLength;
    private boolean utilities;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getCampgroundId() {
        return campgroundId;
    }

    public void setCampgroundId(int campgroundId) {
        this.campgroundId = campgroundId;
    }

    public int getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(int siteNumber) {
        this.siteNumber = siteNumber;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public int getMaxRvLength() {
        return maxRvLength;
    }

    public void setMaxRvLength(int maxRvLength) {
        this.maxRvLength = maxRvLength;
    }

    public boolean isUtilities() {
        return utilities;
    }

    public void setUtilities(boolean utilities) {
        this.utilities = utilities;
    }

    @Override
    public String toString() {
        return "Site{" +
                "siteId=" + siteId +
                ", campgroundId=" + campgroundId +
                ", siteNumber=" + siteNumber +
                ", maxOccupancy=" + maxOccupancy +
                ", accessible=" + accessible +
                ", maxRvLength=" + maxRvLength +
                ", utilities=" + utilities +
                '}';
    }
}
