package com.belajar.ecommerce.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.belajar.ecommerce.models.entities.OrderDetail;
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
