package com.techelevator.dao;

import com.techelevator.model.Customer;

import java.util.List;

public interface CustomerDao {

    // Step Four: Add a new DAO method





    /**
     * Get customers whose first or last names include the given search string.
     *
     * @param search the string to search for in customer names
     * @return a List of Customer objects
     */
    List<Customer> findCustomersByName(String search);

}
