package com.belajar.ecommerce.services;

import com.belajar.ecommerce.models.entities.Product;
import com.belajar.ecommerce.models.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        if(product.getId() != null){
            Product currentProduct = findById(product.getId());
            if(currentProduct != null){
                if(product.getName() != null){
                    currentProduct.setName(product.getName());
                }
                if(product.getDescription() != null){
                    currentProduct.setDescription(product.getDescription());
                }
                if(product.getImage() != null){
                    currentProduct.setImage(product.getImage());
                }
                if(product.getStock() != null){
                    currentProduct.setStock(product.getStock());
                }
                if(product.getPrice() != null){
                    currentProduct.setPrice(product.getPrice());
                }
                if(product.getCategory() != null){
                    currentProduct.setCategory(product.getCategory());
                }
                return productRepository.save(currentProduct);
            }
        }else{
            return productRepository.save(product);
        }
        return product;
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void removeById(String id) {
        productRepository.deleteById(id);
    }

    public void remove(Product product) {
        productRepository.delete(product);
    }

    public Product changePicture(String id, String image) {
        Product product = findById(id);
        if (product != null) {
            product.setImage(image);
            return save(product);
        }
        return null;
    }

    public Product updateName(String id,Product product) {
        Product prodcut = findById(id);
        if (product != null) {
            product.setName(product.getName());
            product.setDescription(product.getDescription());

        }
        return null;
    }

}
