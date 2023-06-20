package com.targetindia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SupplierDTO {
    private Integer supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private Address address;
    private String phone;
    private String fax;
    private String homepage;

    public class Address {
        @JsonProperty("streetAddress")
        private String address;
        @JsonProperty("city")
        private String city;
        @JsonProperty("region")
        private String region;
        @JsonProperty("postalCode")
        private String postalCode;
        @JsonProperty("country")
        private String country;
    }
}
