package com.app.financial_platform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal balance;
    private AccountType type;
    private Long userId;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) {
        this.transactions.add(t);

        if (t.getType() == TransactionType.INCOME) {
            this.balance = this.balance.add(t.getAmount());
        } else if (t.getType() == TransactionType.EXPENSE) {
            this.balance = this.balance.subtract(t.getAmount());
        }
    }
}
