package com.belajar.ecommerce.services;

import com.belajar.ecommerce.models.entities.User;
import com.belajar.ecommerce.models.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    public User saveUser(User user) {
        User currentUser = userRepository.findByEmail(user.getEmail());
        if (currentUser != null) {
            if(user.getName() != null){
                currentUser.setName(user.getName());
            }
            if(user.getPassword() != null){
//                currentUser.setPassword(this.generateEncryptedPassword(user.getPassword()));
                currentUser.setPassword(user.getPassword());
            }
            if(user.getRole() != null){
                currentUser.setRole(user.getRole());
            }
            if(user.getAddress() != null){
                currentUser.setAddress(user.getAddress());
            }
            if(user.getPhone() != null){
                currentUser.setPhone(user.getPhone());
            }
            if(user.getIsVerified() != null){
                currentUser.setIsVerified(user.getIsVerified());
            }
            return userRepository.save(currentUser);

        }else{
            return userRepository.save(user);
        }
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
