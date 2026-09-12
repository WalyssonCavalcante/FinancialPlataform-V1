package com.app.financial_platform.dto;
import com.app.financial_platform.model.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
public record TransactionRequestDTO(
        @NotNull(message = "O valor é obrigatório") @Positive(message = "O valor deve ser positivo") BigDecimal amount,
        @NotNull(message = "O tipo de transação é obrigatório") TransactionType type,
        @NotNull(message = "O ID da conta é obrigatório") Long accountId,
        @NotNull(message = "O ID da categoria é obrigatório") Long categoryId
) {}
