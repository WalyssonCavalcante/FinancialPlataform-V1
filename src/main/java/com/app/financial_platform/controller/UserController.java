package com.app.financial_platform.controller;

import com.app.financial_platform.dto.LoginRequestDTO;
import com.app.financial_platform.dto.UserRequestDTO;
import com.app.financial_platform.dto.UserResponseDTO;
import com.app.financial_platform.model.User;
import com.app.financial_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@jakarta.validation.Valid @RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<UserResponseDTO> listUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public UserResponseDTO login(@jakarta.validation.Valid @RequestBody LoginRequestDTO dto) {
        return userService.login(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody com.app.financial_platform.dto.UserUpdateRequestDTO dto) {
        return userService.updateUser(id, dto);
    }
}

