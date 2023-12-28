package com.personalFinanceTracker.service;

import com.personalFinanceTracker.model.Category;
import com.personalFinanceTracker.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpleCategory implements InterCategory {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepo.findById(id);
    }

    public void deleteCategory(Category category) {
        categoryRepo.delete(category);
    }

    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }
}
