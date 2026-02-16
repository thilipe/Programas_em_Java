package com.felipe.orderflow.repositories;

import com.felipe.orderflow.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
