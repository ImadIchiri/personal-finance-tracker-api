package com.personalFinanceTracker.controller;

import com.personalFinanceTracker.model.Category;
import com.personalFinanceTracker.service.InterCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    InterCategory categoryService;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> geCategoryById(@PathVariable Long id) {
        Optional<Category> optCategory = categoryService.getCategoryById(id);

        if (optCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optCategory.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}/edit")
    public Category editCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id, @RequestBody Category category) {
        if (id != category.getId()) {
            return new ResponseEntity<>(
                    "Request Error: id on the the path not equal to the one on the Request Body !",
                    HttpStatus.OK);
        }

        categoryService.deleteCategory(category);
        return new ResponseEntity<>("Category Deleted !", HttpStatus.OK);
    }
}
