package com.ecommerce.platform.management.domain.model.agreggates;

import com.ecommerce.platform.management.domain.model.commands.CreateProductCommand;
import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.ecommerce.platform.user.domain.model.aggregates.UserDetails;
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
    private UserDetails userDetails;

    @OneToMany(mappedBy = "product")
    private List<DetailedOrder> detailedOrders;

    public Product(String name, String description, String image, double price, int stock,UserDetails userDetails) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.userDetails=userDetails;
    }
    public Product() {
    }
    public Product (CreateProductCommand command){
        this.name = command.name();
        this.description = command.description();
        this.price = command.price();
        this.stock = command.stock();
    }

}
