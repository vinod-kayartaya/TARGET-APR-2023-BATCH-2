package com.targetindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @Column(name="address")
    private String streetAddress;
    private String city;
    private String region;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;
}
