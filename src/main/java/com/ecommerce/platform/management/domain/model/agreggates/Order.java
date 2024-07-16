package com.ecommerce.platform.management.domain.model.agreggates;

import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Order extends AuditableAbstractAggregateRoot<Order> {
    private String number;
    private Date creationDate;
    private Date receivedDate;
    private double total;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "order")
    private DetailedOrder detailedOrder;

    public Order(String number, Date creationDate, Date receivedDate, double total) {
        this.number = number;
        this.creationDate = creationDate;
        this.receivedDate = receivedDate;
        this.total = total;
    }
    public Order() {
    }

}
