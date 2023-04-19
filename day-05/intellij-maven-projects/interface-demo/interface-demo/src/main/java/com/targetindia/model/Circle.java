package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

// Since the Circle class is an implementation of GeometricShape, we can say that 
// Circle is a type of GeometricShape.

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Circle implements GeometricShape{
    // an object of a Circle is an instanceof Circle, GeometricShape and Object
    private double radius;

    @Override
    public double getArea() {
        double area = PI * radius * radius;
        log.trace("Calculating the area of circle as {}", area);
        return area;
    }

    @Override
    public double getPerimeter() {
            return 2 * PI * radius;
    }

    

}
