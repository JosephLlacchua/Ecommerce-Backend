package com.ecommerce.platform.management.domain.services;

import com.ecommerce.platform.management.domain.model.agreggates.Product;
import com.ecommerce.platform.management.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductByIdQuery query);

}
