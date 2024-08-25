package com.belajar.ecommerce.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "tb_m_user")
@Data
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String Address;
    private String phone;
    private Boolean isVerified;
}
