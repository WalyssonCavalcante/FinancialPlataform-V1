package com.app.financial_platform.controller;
import com.app.financial_platform.dto.TransactionRequestDTO;
import com.app.financial_platform.model.Transaction;
import com.app.financial_platform.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping
    public Transaction createTransaction(@Valid @RequestBody TransactionRequestDTO dto) {
        return transactionService.createTransaction(dto);
    }
}
