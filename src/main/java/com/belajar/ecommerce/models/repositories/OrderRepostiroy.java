package com.belajar.ecommerce.models.repositories;

import com.belajar.ecommerce.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepostiroy extends JpaRepository<Order, String> {
}
