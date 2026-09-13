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
        return accountRepository.save(account);
    }
}
