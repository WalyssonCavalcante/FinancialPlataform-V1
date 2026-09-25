package com.app.financial_platform.service;

import com.app.financial_platform.dto.CategoryRequestDTO;
import com.app.financial_platform.model.Category;
import com.app.financial_platform.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CategoryRequestDTO dto) {
        if (categoryRepository.existsByName(dto.name())) {
            throw new IllegalArgumentException("Erro: Essa categoria já existe");
        }

        Category newCategory = new Category();
        newCategory.setName(dto.name());
        newCategory.setIcon(dto.icon() != null ? dto.icon() : "default-icon.svg");
        newCategory.setColor(dto.color() != null ? dto.color() : "#9ca3af");
        newCategory.setType(dto.type() != null ? dto.type() : com.app.financial_platform.model.TransactionType.EXPENSE);

        return categoryRepository.save(newCategory);
    }

    public java.util.List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategoryLimit(Long id, Double limit) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        category.setMonthlyLimit(limit);
        return categoryRepository.save(category);
    }
}
