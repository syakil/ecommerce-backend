package com.belajar.ecommerce.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_m_product")
public class Product implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private String image;
    private Double stock;
    private BigDecimal price;

    @JoinColumn
    @ManyToOne
    private Category category;

}
