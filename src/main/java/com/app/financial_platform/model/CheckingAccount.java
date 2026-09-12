package com.app.financial_platform.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CheckingAccount extends Account {

    private BigDecimal overdraftLimit;

    public void withdraw(BigDecimal amount){
        BigDecimal maxAvailable = this.getBalance().add(this.overdraftLimit);

        if (amount.compareTo(maxAvailable) > 0){
            throw new IllegalArgumentException("Saque negado! Seu limite disponível é de apenas R$ " + maxAvailable);
        }

        this.setBalance(this.getBalance().subtract(amount));
    }
}
