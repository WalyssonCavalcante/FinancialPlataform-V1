package com.app.financial_platform.config;

import com.app.financial_platform.model.Category;
import com.app.financial_platform.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Despesas
        seedIfMissing("Moradia", "house-icon.svg", "#8b5cf6", com.app.financial_platform.model.TransactionType.EXPENSE, 2000.0);
        seedIfMissing("Cartão de crédito", "credit-icon.svg", "#ef4444", com.app.financial_platform.model.TransactionType.EXPENSE, 1500.0);
        seedIfMissing("Transporte", "transport-icon.svg", "#0ea5e9", com.app.financial_platform.model.TransactionType.EXPENSE, 500.0);
        seedIfMissing("Alimentação", "groceries-icon.svg", "#22c55e", com.app.financial_platform.model.TransactionType.EXPENSE, 1200.0);
        seedIfMissing("Compras", "Shopping-icon.svg", "#4f46e5", com.app.financial_platform.model.TransactionType.EXPENSE, 800.0);
        
        // Receitas
        seedIfMissing("Salário", "default-icon.svg", "#10b981", com.app.financial_platform.model.TransactionType.INCOME, 0.0);
        seedIfMissing("Investimentos", "default-icon.svg", "#3b82f6", com.app.financial_platform.model.TransactionType.INCOME, 0.0);
        seedIfMissing("Freelance", "default-icon.svg", "#f59e0b", com.app.financial_platform.model.TransactionType.INCOME, 0.0);
    }

    private void seedIfMissing(String name, String icon, String color, com.app.financial_platform.model.TransactionType type, Double limit) {
        Category category = categoryRepository.findAll().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(new Category());

        category.setName(name);
        if (category.getIcon() == null) category.setIcon(icon);
        if (category.getColor() == null) category.setColor(color);
        if (category.getMonthlyLimit() == null) category.setMonthlyLimit(limit);
        category.setType(type);

        categoryRepository.save(category);
        System.out.println("Seeded/Updated category: " + name);
    }

}
