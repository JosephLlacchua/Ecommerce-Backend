package com.ecommerce.platform.management.domain.model.agreggates;

import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class DetailedOrder extends AuditableAbstractAggregateRoot<DetailedOrder> {

    private String name;
    private double amount;
    private double price;
    private double total;

    @OneToOne
    private Order order;

    @ManyToOne
    private Product product;

    public DetailedOrder(String name,double amount,double price ,double total){
        this.name=name;
        this.amount=amount;
        this.price=price;
        this.total=total;
    }
    public DetailedOrder(){

    }
}
