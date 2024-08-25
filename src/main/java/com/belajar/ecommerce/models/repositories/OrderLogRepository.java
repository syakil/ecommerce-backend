package com.belajar.ecommerce.models.repositories;

import com.belajar.ecommerce.models.entities.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogRepository extends JpaRepository<OrderLog, String> {
}
