package com.app.financial_platform.service;

import com.app.financial_platform.dto.AccountRequestDTO;
import com.app.financial_platform.model.CheckingAccount;
import com.app.financial_platform.model.Account;
import com.app.financial_platform.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(AccountRequestDTO dto) {
        CheckingAccount account = new CheckingAccount();
        account.setName(dto.name());
        account.setBalance(BigDecimal.ZERO);
        account.setOverdraftLimit(new BigDecimal("100.00"));
        account.setUserId(dto.userId());
        return accountRepository.save(account);
    }

    public java.util.List<Account> getAccountsByUserId(Long userId) {
        if (userId == null) return accountRepository.findAll();
        return accountRepository.findAll().stream().filter(a -> userId.equals(a.getUserId())).toList();
    }
}
