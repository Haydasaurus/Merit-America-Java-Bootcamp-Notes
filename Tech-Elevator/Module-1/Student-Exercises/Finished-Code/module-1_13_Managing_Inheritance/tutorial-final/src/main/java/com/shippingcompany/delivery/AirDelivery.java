package com.shippingcompany.delivery;

public class AirDelivery extends Delivery {

    public static final int ONE_DAY_IN_MINUTES = 24 * 60;

    @Override
    public int getDuration() {
        return ONE_DAY_IN_MINUTES;
    }

}
