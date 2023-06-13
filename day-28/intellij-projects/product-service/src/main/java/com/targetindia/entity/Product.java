package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "units_in_stock")
    private Integer unitsInStock;
    @Column(name = "units_on_order")
    private Integer unitsOnOrder;
    @Column(name = "reorder_level")
    private Integer reorderLevel;
    private Integer discontinued;
}
