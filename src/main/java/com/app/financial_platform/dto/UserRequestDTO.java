package com.app.financial_platform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(@NotBlank(message = "O nome não pode ser vazio!") String name, @NotBlank(message = "O e-mail é obrigatorio") @Email(message = "O formato de e-mail é invalido") String email, @NotBlank(message = "A senha é obrigatoria") String password) {
}
