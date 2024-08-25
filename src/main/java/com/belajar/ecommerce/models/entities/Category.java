package com.belajar.ecommerce.models.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name="tb_m_category")
@Data
@Entity
public class Category implements Serializable {

    @Id
    private String id;

    private String name;
}
