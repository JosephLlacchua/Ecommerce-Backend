package com.ecommerce.platform.management.domain.model.agreggates;

import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import lombok.Data;

@Data
public class Product extends AuditableAbstractAggregateRoot<Product> {
    private String name;
    private String description;
    private String image;
    private double price;
    private int stock;

    public Product(String name, String description, String image, double price, int stock) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
    }
}
