package com.belajar.ecommerce.controllers;

import com.belajar.ecommerce.dto.ResponseData;
import com.belajar.ecommerce.dto.UserDto;
import com.belajar.ecommerce.models.entities.User;
import com.belajar.ecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<User>> register(@RequestBody UserDto userDto) {
        User entity = modelMapper.map(userDto, User.class);
        entity = userService.saveUser(entity);
        ResponseData<User> responseData = new ResponseData<>();
        responseData.setStatus(true);
        responseData.getMessages().add("User has been registered");
        responseData.setData(entity);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseData<User>> findByEmail(@PathVariable String email) {
        User entity = userService.findByEmail(email);
        ResponseData<User> responseData = new ResponseData<>();
        responseData.setStatus(true);
        responseData.getMessages().add("User found");
        responseData.setData(entity);
        return ResponseEntity.ok(responseData);
    }

}
