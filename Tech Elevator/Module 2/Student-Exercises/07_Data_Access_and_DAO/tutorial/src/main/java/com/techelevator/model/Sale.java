package com.techelevator.model;

import java.math.BigDecimal;

public class Sale {

    private long saleId;
    private BigDecimal total;
    private boolean delivery;
    private Long customerId; // Long rather than long, because it may be null

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return String.format("Sale %d: $%s (%s)", getSaleId(), getTotal(), isDelivery()? "delivery": "carryout");
    }
}
