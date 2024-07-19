package com.ecommerce.platform.management.infrastructure.persistence.jpa;

import com.ecommerce.platform.management.domain.model.agreggates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
