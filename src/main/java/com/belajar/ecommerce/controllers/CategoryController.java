package com.belajar.ecommerce.controllers;

import com.belajar.ecommerce.dto.CategoryDto;
import com.belajar.ecommerce.dto.ResponseData;
import com.belajar.ecommerce.models.entities.Category;
import com.belajar.ecommerce.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public ResponseEntity<ResponseData<Category>> save(@RequestBody CategoryDto categorydto) {
        ResponseData<Category> response = new ResponseData<>();
        try{
            Category category = modelMapper.map(categorydto, Category.class);
            category = categoryService.save(category);
            response.setStatus(true);
            response.getMessages().add("Category berhasil disimpan");
            response.setData(category);
            return ResponseEntity.ok(response);

        }catch (Exception e) {
            response.setStatus(false);
            response.getMessages().add(e.getMessage());
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> findById(@PathVariable("id") String id) {
        ResponseData<Category> response = new ResponseData<>();
        Category category = categoryService.findById(id);
        if (category == null) {
            response.setStatus(false);
            response.getMessages().add("Category not found");
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.setStatus(true);
        response.getMessages().add("Category found");
        response.setData(category);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> removeById(@PathVariable("id") String id) {
        ResponseData<Category> response = new ResponseData<>();
        Category category = categoryService.findById(id);
        if (category == null) {
            response.setStatus(false);
            response.getMessages().add("Category not found");
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        categoryService.removeById(id);
        response.setStatus(true);
        response.getMessages().add("Category successfully deleted");
        response.setData(null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> update(@PathVariable("id") String id, @RequestBody CategoryDto categorydto) {
        ResponseData<Category> response = new ResponseData<>();
        Category category = categoryService.findById(id);
        if (category == null) {
            response.setStatus(false);
            response.getMessages().add("Category not found");
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        category = modelMapper.map(categorydto, Category.class);
        category.setId(id);
        category = categoryService.save(category);
        response.setStatus(true);
        response.getMessages().add("Category successfully updated");
        response.setData(category);
        return ResponseEntity.ok(response);
    }
}
