package com.jwt.persistance.repositories;

import com.jwt.persistance.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
