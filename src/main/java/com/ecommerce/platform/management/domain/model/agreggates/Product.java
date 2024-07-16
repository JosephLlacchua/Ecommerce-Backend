package com.ecommerce.platform.management.domain.model.agreggates;

import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Product extends AuditableAbstractAggregateRoot<Product> {
    private String name;
    private String description;
    private String image;
    private double price;
    private int stock;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "product")
    private List<DetailedOrder> detailedOrders;

    public Product(String name, String description, String image, double price, int stock,User user) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.user=user;
    }
    public Product() {
    }

}
