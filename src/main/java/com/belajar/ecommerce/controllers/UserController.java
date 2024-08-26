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

        ResponseData<User> responseData = new ResponseData<>();
        try{
            User entity = modelMapper.map(userDto, User.class);
            entity = userService.save(entity);
            responseData.setStatus(true);
            responseData.getMessages().add("User has been registered");
            responseData.setData(entity);
            return ResponseEntity.ok(responseData);
        }catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            responseData.setData(null);
            return ResponseEntity.badRequest().body(responseData);
        }
    }


}
