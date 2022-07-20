package com.shippingcompany.delivery;

public class TruckDelivery extends Delivery {

    /**
     * The top speed of the truck represented in mph
     */
    public static final double TRUCK_TOP_SPEED = 60.0;

    @Override
    public int getDuration() {
        double decimalHours = (double) super.getDistance() / TRUCK_TOP_SPEED;
        return convertHoursToMinutes(decimalHours);
    }

}
