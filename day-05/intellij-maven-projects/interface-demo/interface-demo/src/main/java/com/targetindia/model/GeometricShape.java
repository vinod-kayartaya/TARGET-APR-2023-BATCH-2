package com.targetindia.model;


public interface GeometricShape {
    double PI = 3.14157; // public, static and final
    double getArea(); // public and abstract
    default double getPerimeter(){ // this is inherited to all subclasses
        return 0;
    }
}
