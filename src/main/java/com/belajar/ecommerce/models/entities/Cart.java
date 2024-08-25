package com.belajar.ecommerce.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "tb_r_cart")
@Data
@Entity
public class Cart implements Serializable {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private User user;
    @ManyToOne
    @JoinColumn
    private Product product;
    private int quantity;
}
