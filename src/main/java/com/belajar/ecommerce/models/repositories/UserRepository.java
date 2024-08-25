package com.belajar.ecommerce.models.repositories;

import com.belajar.ecommerce.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
