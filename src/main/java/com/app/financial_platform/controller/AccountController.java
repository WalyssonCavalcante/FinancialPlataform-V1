package com.app.financial_platform.controller;

import com.app.financial_platform.dto.AccountRequestDTO;
import com.app.financial_platform.model.Account;
import com.app.financial_platform.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@Valid @RequestBody AccountRequestDTO dto) {
        return accountService.createAccount(dto);
    }

    @GetMapping
    public java.util.List<Account> getAccounts(@RequestParam(required = false) Long userId) {
        return accountService.getAccountsByUserId(userId);
    }
}
