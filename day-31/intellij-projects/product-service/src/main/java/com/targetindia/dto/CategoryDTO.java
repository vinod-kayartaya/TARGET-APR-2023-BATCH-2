package com.targetindia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonPropertyOrder({"categoryId", "categoryName", "description"})
public class CategoryDTO {
    @JsonProperty("categoryId")
    @XmlElement(name="categoryId")
    private Integer id;
    @JsonProperty("categoryName")
    @XmlElement(name="categoryName")
    private String name;
    private String description;
}
