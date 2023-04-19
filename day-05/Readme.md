# Interfaces

-   An interface is a data type for creating reference variables
-   Unlike a class, no default constructor is given by the compiler
-   While you can created a variable of an interface, an object of an interface type cannot be created.
-   An object of an interface is REALIZED using an object of some class that implements the interface

For example, imageine we have an `abstract class` called `Shape` with a member function called `getArea()`. In order to create a Shape object, we would instantiate classes like `Circle` or `Rectangle` etc, provided they extend the `Shape` class.

```java
public abstract class Shape {
    public abstract double getArea();
}
public class Circle extends Shape {
    // members of Circle class
    // ...

    @Override
    public double getArea(){
        ///....
    }
}

Shape s1 = new Circle();
```

Now if the type `Shape` is an interface, then it would look like this:

```java
public interface Shape {
    public abstract double getArea();
}
```

and the class Circle would look like this:

```java
public class Circle implements Shape {
    // members of Circle class
    // ...

    // overriding the abstract methods in the interface is MANDATORY
    @Override
    public double getArea(){
        ///....
    }
}
```

Now we can create a reference of a `Shape` interface, and assign an object of `Circle`. That is because, Circle is a type of Shape now.

```java
Triangle t1 = new Triangle(); // this too implements Shape
Circle c1 = new Circle();
Shape s1;

s1 = c1;
s1.getArea(); // gets the area of the Circle that it points
s1 = t1;
s1.getArea(); // gets the area of the Rectangle
```

-   While a class can have only one superclass (if not mentioned, it always extends `java.lang.Object`), it may implement multiple interfaces.
-   Extending a class (even an abstract one) allows the subclass to benefit from the code available in the superclass. Whereas, implementing one or more interfaces will only put some constraints on the implementing class to provide method bodies for all the abstract methods of the interface. Here there is no benefit of code-re-usability.
-   If we have unrelated classes implementing a common interface, then we can say that objects of all those classes are objects of the interface type.

## New feature in Java 8 allows us have method bodies inside an interface!!

-   In Java 8, the developers of Java decided to have additional methods in some interface (specifically, Java collections), but this forced them to implmement these methods in hundreds of classes in collection framework.
-   As an alternative, they introduced a keyword called `default` that allows the interface method to have a body. This acts like a fallback method for those `old` implementations.

# Exceptions in Java

-   An `exception` is a erroneous scenario at the runtime
-   Runtime errors that can be handled by the developer inside the code are classified as `Exception` and those which cannot be handled inside the code (such as out-of-memory issue), are grouped under `Error`.
-   In Java, at the top of the hierarchy is a class called `Throwable`
