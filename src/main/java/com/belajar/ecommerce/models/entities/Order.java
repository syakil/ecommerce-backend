package com.belajar.ecommerce.models.entities;

import com.belajar.ecommerce.models.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_r_order")
public class Order implements Serializable {
    @Id
    @Column(unique = true)
    private String OrderNumber;
    @JoinColumn
    @ManyToOne
    private User user;
    private String Address;
    private String TotalItem;
    private String TotalPrice;
    @Enumerated(EnumType.STRING)
    private StatusOrder Status;
    @Temporal(TemporalType.TIMESTAMP)
    private String createdAt;
    private String updatedAt;
}
