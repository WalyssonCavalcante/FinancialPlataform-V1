package com.app.financial_platform.controller;

import com.app.financial_platform.dto.CategoryRequestDTO;
import com.app.financial_platform.model.Category;
import com.app.financial_platform.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@jakarta.validation.Valid @RequestBody CategoryRequestDTO dto){
        return categoryService.createCategory(dto);
    }
}
