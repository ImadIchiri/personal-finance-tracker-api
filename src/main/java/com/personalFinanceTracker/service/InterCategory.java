package com.personalFinanceTracker.service;

import com.personalFinanceTracker.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface InterCategory {
    Category createCategory(Category category);

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    void deleteCategory(Category category);

    Category updateCategory(Category category);
}
