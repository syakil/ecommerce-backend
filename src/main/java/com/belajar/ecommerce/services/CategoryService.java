package com.belajar.ecommerce.services;

import com.belajar.ecommerce.models.entities.Category;
import com.belajar.ecommerce.models.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void removeById(String id) {
        categoryRepository.deleteById(id);
    }

    public void remove(Category category) {
        categoryRepository.delete(category);
    }

}
