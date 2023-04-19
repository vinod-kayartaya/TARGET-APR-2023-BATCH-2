package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle implements GeometricShape{

    private double width;
    private double height;

    @Override
    public double getArea() {
        double area =  width*height;
        log.trace("Calculating area of rect as {}", area);

        return area;
    }
    
}
