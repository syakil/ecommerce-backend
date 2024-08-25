package com.belajar.ecommerce.models.repositories;

import com.belajar.ecommerce.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
