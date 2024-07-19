package com.ecommerce.platform.management.application.internal.queryservices;

import com.ecommerce.platform.management.domain.model.agreggates.Product;
import com.ecommerce.platform.management.domain.model.queries.GetProductByIdQuery;
import com.ecommerce.platform.management.domain.services.ProductQueryService;
import com.ecommerce.platform.management.infrastructure.persistence.jpa.ProductRepository;

import java.util.Optional;

public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }
}
