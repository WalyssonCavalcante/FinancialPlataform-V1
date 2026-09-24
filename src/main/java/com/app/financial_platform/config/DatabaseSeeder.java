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
        seedIfMissing("Moradia", "house-icon.svg", "#8b5cf6", com.app.financial_platform.model.TransactionType.EXPENSE);
        seedIfMissing("Cartão de crédito", "credit-icon.svg", "#ef4444", com.app.financial_platform.model.TransactionType.EXPENSE);
        seedIfMissing("Transporte", "transport-icon.svg", "#0ea5e9", com.app.financial_platform.model.TransactionType.EXPENSE);
        seedIfMissing("Alimentação", "groceries-icon.svg", "#22c55e", com.app.financial_platform.model.TransactionType.EXPENSE);
        seedIfMissing("Compras", "Shopping-icon.svg", "#4f46e5", com.app.financial_platform.model.TransactionType.EXPENSE);
        
        // Receitas
        seedIfMissing("Salário", "default-icon.svg", "#10b981", com.app.financial_platform.model.TransactionType.INCOME);
        seedIfMissing("Investimentos", "default-icon.svg", "#3b82f6", com.app.financial_platform.model.TransactionType.INCOME);
        seedIfMissing("Freelance", "default-icon.svg", "#f59e0b", com.app.financial_platform.model.TransactionType.INCOME);
    }

    private void seedIfMissing(String name, String icon, String color, com.app.financial_platform.model.TransactionType type) {
        Category category = categoryRepository.findAll().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(new Category());

        category.setName(name);
        if (category.getIcon() == null) category.setIcon(icon);
        if (category.getColor() == null) category.setColor(color);
        category.setType(type);

        categoryRepository.save(category);
        System.out.println("Seeded/Updated category: " + name);
    }

}
