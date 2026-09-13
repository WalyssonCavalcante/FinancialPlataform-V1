package com.app.financial_platform.service;
import com.app.financial_platform.dto.TransactionRequestDTO;
import com.app.financial_platform.model.Account;
import com.app.financial_platform.model.Category;
import com.app.financial_platform.model.Transaction;
import com.app.financial_platform.repository.AccountRepository;
import com.app.financial_platform.repository.CategoryRepository;
import com.app.financial_platform.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Transaction createTransaction(TransactionRequestDTO dto) {
        Account account = accountRepository.findById(dto.accountId())
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        Transaction transaction = new Transaction();
        transaction.setAmount(dto.amount());
        transaction.setType(dto.type());
        transaction.setAccount(account);
        transaction.setCategory(category);
        account.addTransaction(transaction);
        accountRepository.save(account);
        return transactionRepository.save(transaction);
    }
}
