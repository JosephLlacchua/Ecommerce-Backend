package com.ecommerce.platform.user.interfaces.rest.resources;

public record CreateUserDetailsResource(String fullname, String direccion, String telefono, Long userId) {
}
