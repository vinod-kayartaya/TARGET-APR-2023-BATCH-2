package com.targetindia.model;

public class Product {
    private int id;
    private String name;
    private double unitPrice;

    // good practice is to have default constructor
    public Product() {
    }
    // overloaded constructor
    public Product(int id, String name, double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }
    // another overloaded constructor
    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
