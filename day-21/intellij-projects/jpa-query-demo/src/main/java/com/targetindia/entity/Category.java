package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    private String description;

    // by default, loading of collection types is done in LAZY fashion
    @OneToMany(fetch = FetchType.LAZY) // one category has many products
    @JoinColumn(name="category_id") // get all the products that have the same category_id as this object
    private List<Product> products;
}
