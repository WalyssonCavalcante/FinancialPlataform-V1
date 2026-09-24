package com.app.financial_platform.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        @NotBlank(message = "Categoria não pode ser vazia") String name,
        String icon,
        String color,
        com.app.financial_platform.model.TransactionType type
) {
}
