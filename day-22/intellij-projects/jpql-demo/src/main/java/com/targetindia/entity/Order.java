package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // instead of customerId -- Who placed this order?
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee; // instead of employeeId -- Who processed this order?

    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "required_date")
    private Date requiredDate;
    @Column(name = "shipped_date")
    private Date shippedDate;

    @Column(name = "ship_via")
    private Integer shipped_by; // instead of shipVia; Why don't we get an object of Shipper class?
    private Double freight;

    @Column(name = "ship_name")
    private String shippedTo; // instead of shipName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "ship_address")),
            @AttributeOverride(name = "city", column = @Column(name = "ship_city")),
            @AttributeOverride(name = "region", column = @Column(name = "ship_region")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "ship_postal_code")),
            @AttributeOverride(name = "country", column = @Column(name = "ship_country"))
    })
    private Address address; // where to ship this order?

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<LineItem> lineItems;

}
