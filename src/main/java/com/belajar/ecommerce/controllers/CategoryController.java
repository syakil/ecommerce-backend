package com.belajar.ecommerce.controllers;

import com.belajar.ecommerce.models.entities.Category;
import com.belajar.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public Category save(Category category) {
        return categoryService.save(category);
    }


}
