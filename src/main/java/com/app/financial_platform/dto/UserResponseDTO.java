package com.app.financial_platform.dto;

import com.app.financial_platform.model.User;

public record UserResponseDTO(Long id, String name, String email) {

    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
