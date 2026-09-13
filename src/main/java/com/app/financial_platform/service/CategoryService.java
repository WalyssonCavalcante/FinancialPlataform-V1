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

        return categoryRepository.save(newCategory);
    }
}
