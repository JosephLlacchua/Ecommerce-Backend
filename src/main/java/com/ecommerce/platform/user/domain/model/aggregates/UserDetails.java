package com.ecommerce.platform.user.domain.model.aggregates;

import com.ecommerce.platform.iam.domain.model.aggregates.User;
import com.ecommerce.platform.management.domain.model.agreggates.Order;
import com.ecommerce.platform.management.domain.model.agreggates.Product;
import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.ecommerce.platform.user.domain.model.commands.CreateUserDetailsCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserDetails extends AuditableAbstractAggregateRoot<UserDetails> {
    private String fullname;
    private String direccion;
    private String telefono;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToMany(mappedBy = "userDetails")
    private List<Product> products;

    @OneToMany(mappedBy = "userDetails")
    private List<Order> orders;

    public UserDetails(String fullname, String direccion, String telefono) {
        this.fullname = fullname;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public UserDetails() {

    }

    public UserDetails(CreateUserDetailsCommand command, User user) {
        this.fullname = command.fullname();
        this.direccion = command.direccion();
        this.telefono = command.telefono();
        this.user = user;
    }

}