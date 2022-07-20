package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.JdbcCustomerDao;
import com.techelevator.dao.JdbcSaleDao;
import com.techelevator.dao.SaleDao;
import com.techelevator.model.Customer;
import com.techelevator.model.Sale;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.List;

public class Tutorial {

    private SaleDao saleDao;
    private CustomerDao customerDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        // Step One: Configure the database connection


        Tutorial tutorial = new Tutorial(dataSource);
        tutorial.run();
    }

    public Tutorial(DataSource dataSource) {
        saleDao = new JdbcSaleDao(dataSource);
        customerDao = new JdbcCustomerDao(dataSource);
    }

    private void run() {
        System.out.println("Total Sales: $" + saleDao.getTotalSales());

        // Step Three: Copy returned values into an object


        // Step Four: Add a new DAO method


        // Step Five: Call a DAO method that returns a List

    }
}
