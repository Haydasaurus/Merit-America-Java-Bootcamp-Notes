package com.techelevator.dao;

import com.techelevator.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;

public class JdbcSaleDao implements SaleDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSaleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public BigDecimal getTotalSales() {
        // Step Two: Add SQL for retrieving total sales
        return jdbcTemplate.queryForObject("SELECT SUM(total) FROM sale;", BigDecimal.class);
    }

    @Override
    public Sale getSale(long saleId) {
        Sale sale = null;
        String sql = "SELECT sale_id, total, is_delivery, customer_id " +
                     "FROM sale " +
                     "WHERE sale_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
        if (results.next()) {
            sale = mapRowToSale(results);
        }
        return sale;
    }

    private Sale mapRowToSale(SqlRowSet rowSet) {
        Sale sale = new Sale();
        // Step Three: Copy returned values into an object
        sale.setSaleId(rowSet.getLong("sale_id"));
        sale.setTotal(rowSet.getBigDecimal("total"));
        sale.setDelivery(rowSet.getBoolean("is_delivery"));
        sale.setCustomerId(rowSet.getLong("customer_id"));
        if (rowSet.wasNull()) {
            sale.setCustomerId(null);
        }
        return sale;
    }
}
