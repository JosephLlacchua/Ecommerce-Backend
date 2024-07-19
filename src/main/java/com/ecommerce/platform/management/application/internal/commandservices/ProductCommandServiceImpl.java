package com.ecommerce.platform.management.application.internal.commandservices;

import com.ecommerce.platform.management.domain.model.agreggates.Product;
import com.ecommerce.platform.management.domain.model.commands.CreateProductCommand;
import com.ecommerce.platform.management.domain.model.commands.DeleteProductCommand;
import com.ecommerce.platform.management.domain.model.commands.UpdateProductCommand;
import com.ecommerce.platform.management.domain.services.ProductCommandService;
import com.ecommerce.platform.management.infrastructure.persistence.jpa.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {


    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Long handle(CreateProductCommand command) {
        var product =new Product(command);
        try{
            productRepository.save(product);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while saving product: " + e.getMessage());
        }
        return product.getId();
    }

    @Override
    public Optional<Product> handle(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.id());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(command.name());
            product.setDescription(command.description());
            product.setPrice(command.price());
            product.setStock(command.stock());
            try {
                productRepository.save(product);
                return Optional.of(product);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error while updating product: " + e.getMessage());
            }
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void handle(DeleteProductCommand command) {
        if(productRepository.existsById(command.productId())){
            throw new IllegalArgumentException("Product does not exist");
        }
        try {
            productRepository.deleteById(command.productId());
        }catch (Exception e){
            throw new IllegalArgumentException("Error while deleting product: " + e.getMessage());
        }

    }
}
