package com.belajar.ecommerce.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "tb_t_order_log")
@Data
@Entity
public class OrderLog implements Serializable {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Order order;
    private int logType;
    private String logMessage;
    @JoinColumn
    @ManyToOne
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private String createdAt;
    private String updatedAt;
}
