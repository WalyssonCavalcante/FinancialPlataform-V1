package com.app.financial_platform.controller;

import com.app.financial_platform.dto.CategoryRequestDTO;
import com.app.financial_platform.model.Category;
import com.app.financial_platform.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@jakarta.validation.Valid @RequestBody CategoryRequestDTO dto) {
        return categoryService.createCategory(dto);
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @org.springframework.web.bind.annotation.PatchMapping("/{id}/limit")
    public Category updateCategoryLimit(
            @org.springframework.web.bind.annotation.PathVariable Long id,
            @RequestBody java.util.Map<String, Double> payload) {
        Double limit = payload.get("limit");
        return categoryService.updateCategoryLimit(id, limit);
    }
}
