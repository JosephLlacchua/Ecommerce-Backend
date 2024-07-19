package com.ecommerce.platform.management.domain.services;

import com.ecommerce.platform.management.domain.model.agreggates.Product;
import com.ecommerce.platform.management.domain.model.commands.CreateProductCommand;
import com.ecommerce.platform.management.domain.model.commands.DeleteProductCommand;
import com.ecommerce.platform.management.domain.model.commands.UpdateProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    Long handle (CreateProductCommand command);
    Optional<Product> handle(UpdateProductCommand command);
    void handle(DeleteProductCommand command);
}
