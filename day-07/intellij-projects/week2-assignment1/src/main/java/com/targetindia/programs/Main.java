package com.targetindia.programs;

import com.targetindia.model.Circle;
import com.targetindia.model.Cylinder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for (Circle c : circles) {
            log.trace("Area of circular region of the cylinder is {} sq.units", c.getArea());
            if (c instanceof Cylinder) {
                Cylinder c1 = (Cylinder) c;
                log.trace("Volume of the cylinder is {} sq.units", c1.getVolume());
            }
        }
    }
}
