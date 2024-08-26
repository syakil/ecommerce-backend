package com.belajar.ecommerce.services;

import ch.qos.logback.core.util.StringUtil;
import com.belajar.ecommerce.models.entities.User;
import com.belajar.ecommerce.models.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    public String generateEncryptedPassword(String plainPassword) {
//        return passwordEncoder.encode(plainPassword);
//    }

//    public boolean checkPassword(String plainPassword, String encryptedPassword) {
//        return passwordEncoder.matches(plainPassword, encryptedPassword);
//    }

// Untuk verifikasi
//    boolean matches = passwordService.checkPassword(plainPassword, encryptedPassword);
//    System.out.println("Password match: " + matches);

    public User save(User user) {
        if(!StringUtils.hasText(user.getName())){
            throw new RuntimeException("Name is required");
        }
        if(!StringUtils.hasText(user.getEmail())){
            throw new RuntimeException("Email is required");
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new RuntimeException("Password is required");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void removeById(String id) {
        userRepository.deleteById(id);
    }

    public void remove(User user) {
        userRepository.delete(user);
    }

}
