package com.agency.digital_agency.controller;

import com.agency.digital_agency.model.Category;
import com.agency.digital_agency.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Marks this class as a REST Controller
@RequestMapping("/api/categories") // All endpoints in this class will start with this URL

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Handles HTTP GET requests to /api/categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}