package com.gd.gdfood_api.api.V1.repositories;

import com.gd.gdfood_api.api.V1.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
