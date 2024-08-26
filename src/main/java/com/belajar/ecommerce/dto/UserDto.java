package com.belajar.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String address;
    private String phone;
    private Boolean isVerified;
}
