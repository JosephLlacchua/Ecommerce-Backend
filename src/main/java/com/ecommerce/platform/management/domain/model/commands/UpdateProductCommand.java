package com.ecommerce.platform.management.domain.model.commands;

public record UpdateProductCommand(Long id, String name, String description, double price, int stock) {
}
