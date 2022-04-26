package com.techelevator.dao;

import com.techelevator.model.Sale;

import java.math.BigDecimal;
import java.util.List;

public interface SaleDao {

    /**
     * Get the grand total of sales in the datastore.
     *
     * @return the total as a BigDecimal
     */
    BigDecimal getTotalSales();

    /**
     * Get the sale from the datastore with the given id.
     *
     * @param saleId the id of the sale to retrieve
     * @return a complete Sale object
     */
    Sale getSale(long saleId);


}
