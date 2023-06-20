package com.targetindia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Data;

@Entity
@Data
@Table(name="categories")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
    @Id
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name="category_name")
    private String categoryName;
    private String description;
    @XmlTransient
    @JsonIgnore
    private byte[] picture;
}
