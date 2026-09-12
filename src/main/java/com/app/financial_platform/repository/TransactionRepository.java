package com.app.financial_platform.repository;
import com.app.financial_platform.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
