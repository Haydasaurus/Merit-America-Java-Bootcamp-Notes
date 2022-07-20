package com.shippingcompany.delivery;

public class DroneDelivery extends Delivery {

    /**
     * The top speed of the drone represented in mph
     */
    public static final double DRONE_TOP_SPEED = 100.0;

    @Override
    public int getDuration() {
        int weight = super.getShipment().getWeight();
        double topSpeedWithWeight = DRONE_TOP_SPEED / weight;
        double decimalHours = super.getDistance() / topSpeedWithWeight;
        return convertHoursToMinutes(decimalHours);
    }
}
