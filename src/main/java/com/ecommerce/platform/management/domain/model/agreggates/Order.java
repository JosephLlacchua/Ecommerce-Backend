package com.ecommerce.platform.management.domain.model.agreggates;

import lombok.Data;

import java.util.Date;

@Data
public class Order  {
    private String number;
    private Date creationDate;
    private Date receivedDate;
    private double total;

    public Order(String number, Date creationDate, Date receivedDate, double total) {
        this.number = number;
        this.creationDate = creationDate;
        this.receivedDate = receivedDate;
        this.total = total;
    }
    public Order() {
    }

}
