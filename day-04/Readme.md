# Abstract classes

-   A class marked as `abstract`
-   A variable of an abstract can be created; but cannot create objects of an abstract class
-   How do we call the methods of the abstract class, if we cannot create an object?
    -   We must inherit the members of abstract class and using an object of the subclass, we can call the methods
-   May contain 0 or more abstract methods
-   May contain 0 or more concrete methods also

# Abstract method

-   Every method in a class must have a body
-   Or it must be declared as abstract
-   An abstract method can only exist inside an abstract class
-   Since the subclasses inherit everything from the parent, even the abstract method is also inherited
    -   this means the subclasses are also expected to be abstract
    -   or the subclass may override the inherited abstract method
