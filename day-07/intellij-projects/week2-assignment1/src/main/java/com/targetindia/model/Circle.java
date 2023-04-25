package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ",color=" + color + "]";
    }
}
