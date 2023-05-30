package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="suppliers")
public class Supplier {
    @Id
    @Column(name="supplier_id")
    private Integer supplierId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="contact_title")
    private String contactTitle;

    @Embedded // --> do not map "address" to any column, but map the members of "address" to columns
    private Address address; // aggregation for code reusability

    private String phone;
    private String fax;
    @Column(name="home_page")
    private String homepage;
}
