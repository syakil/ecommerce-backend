package com.belajar.ecommerce.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "tb_t_order_detail")
@Data
@Entity
public class OrderDetail implements Serializable {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Order order;
    @JoinColumn
    @ManyToOne
    private Product product;
    private String quantity;
    private String price;
    private String totalPrice;
    @Temporal(TemporalType.TIMESTAMP)
    private String createdAt;
}
