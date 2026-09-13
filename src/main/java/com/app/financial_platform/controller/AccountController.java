package com.app.financial_platform.controller;

import com.app.financial_platform.dto.AccountRequestDTO;
import com.app.financial_platform.model.Account;
import com.app.financial_platform.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@Valid @RequestBody AccountRequestDTO dto) {
        return accountService.createAccount(dto);
    }
}
