package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "order_details")
public class LineItem implements Serializable { // an entity class with composite primary key must implement Serializable
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Id
    @Column(name="product_id")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order; // instead of orderId

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product; // instead of productId

    @Column(name = "unit_price")
    private Double unitPrice;
    private Integer quantity;
    private Double discount;
}
