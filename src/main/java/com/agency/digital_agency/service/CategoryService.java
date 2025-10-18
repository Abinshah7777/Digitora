package com.agency.digital_agency.service;

import com.agency.digital_agency.Repository.CategoryRepository;
import com.agency.digital_agency.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a Spring Service component
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor Injection: Spring will automatically provide the CategoryRepository bean
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Business logic method to get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // We can add more methods here later, like saving a new category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}