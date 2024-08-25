package com.belajar.ecommerce.dto;

import com.belajar.ecommerce.models.entities.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private String image;
    private Double stock;
    private BigDecimal price;
    private Category category;
}
