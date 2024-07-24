package com.ecommerce.platform.user.domain.model.commands;

public record CreateUserDetailsCommand(String fullname, String direccion, String telefono,Long userId) {
}
