package com.belajar.ecommerce.controllers;

import com.belajar.ecommerce.dto.ProductDto;
import com.belajar.ecommerce.dto.ResponseData;
import com.belajar.ecommerce.models.entities.Product;
import com.belajar.ecommerce.services.ProductService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id) {
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ResponseData<Product>> save(@RequestBody ProductDto productDto){
        ResponseData<Product> response = new ResponseData<>();
        try {
            Product product = modelMapper.map(productDto, Product.class);
            product = productService.save(product);
            response.setStatus(true);
            response.getMessages().add("Product successfully saved");
            response.setData(product);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatus(false);
            response.getMessages().add(e.getMessage());
            response.setData(null);
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PutMapping("/{id}")
    public Product update(@PathVariable("id") String id, @RequestBody ProductDto productDto) {
        ResponseData<Product> response = new ResponseData<>();
        Product product = modelMapper.map(productDto, Product.class);
        product.setId(id);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") String id) {
        productService.removeById(id);
    }
}
