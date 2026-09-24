package com.app.financial_platform.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountRequestDTO(
    @NotBlank(message = "O nome da conta é obrigatório") String name,
    Long userId
) {
}
