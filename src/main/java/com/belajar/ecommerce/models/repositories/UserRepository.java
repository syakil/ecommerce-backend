package com.belajar.ecommerce.models.repositories;

import com.belajar.ecommerce.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}
