package com.targetindia.supplierservice.entity;

import com.targetindia.supplierservice.model.Address;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_title")
    private String contactTitle;
    @Embedded
    private Address address;
    @Column
    private String phone;
    @Column
    private String fax;
    @Column(name = "home_page")
    private String homepage;
}













