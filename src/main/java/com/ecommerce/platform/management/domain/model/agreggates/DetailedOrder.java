package com.ecommerce.platform.management.domain.model.agreggates;

import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import lombok.Data;


@Data
public class DetailedOrder extends AuditableAbstractAggregateRoot<DetailedOrder> {

    private String name;
    private double amount;
    private double price;
    private double total;

    public DetailedOrder(String name,double amount,double price ,double total){
        this.name=name;
        this.amount=amount;
        this.price=price;
        this.total=total;
    }
    public DetailedOrder(){

    }
}
