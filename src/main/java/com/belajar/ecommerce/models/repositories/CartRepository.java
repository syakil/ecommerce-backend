package com.belajar.ecommerce.models.repositories;

import com.belajar.ecommerce.models.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
}
