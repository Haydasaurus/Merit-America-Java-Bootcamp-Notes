package com.techelevator;

import java.util.Map;

public interface Billable {

    double getBalanceDue(Map<String, Double> servicesRendered);

}
