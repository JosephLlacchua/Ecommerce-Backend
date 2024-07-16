package com.ecommerce.platform.management.domain.model.agreggates;

import com.ecommerce.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import lombok.Data;

@Data
public class User extends AuditableAbstractAggregateRoot<User> {

    private String name;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;

    public User(String name, String username, String email, String direccion, String telefono, String tipo, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.password = password;
    }
    private User(){

    }

}
