package com.ecommerce.platform.management.domain.model.commands;

public record CreateProductCommand(String name, String description, double price, int stock) {
}
