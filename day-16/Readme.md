# Stream API in Java 8

Not to mistake with IO Streams in Java

- Java 8 introduced new APIs for working with large amount of data in a collection, which is known as Stream API
- java.util.stream.Stream is an interface that has many useful functions which look like mathematical operations
  - filter
  - map
  - count
  - min
  - max etc.,
- many of these functions return the same Stream object (that is used to invoke these functions), and because of which, we can create a statement chain

```java
List<Integer> numbers = Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 90);

List<Integer> squaresOfEvens = numbers.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * n)
        .collect(Collectors.toList());
```

- many functions of Stream interface are also terminal functions (which either return non-stream type or void)
- A Stream represents a sequence of elements and support different kinds of operations

Some of the most important `functional interfaces` we may have be aware of before using the stream api:

- java.util.function.Predicate
  - `boolean test(T t)`
  - this can be used to check a condition on the given element
  - For example, if we want know if the input number is even or odd, then an object of Predicate can be represented by this arrow function: `n -> n%2==0`
  - Another example, if we want check if an employee earns more than 15000, then an object of Predicate can be represented as : `e -> e.getSalary() > 15000`
  - Suppose, we have a stream of String (say for example, names), and we want to check if a given string is blank or not. So the predicate would be `name -> name.isBlank()`
  - Some of the Stream functions that accept a Predicate are:
    1. filter
    1. anyMatch
    1. allMatch
    1. noneMatch
- java.util.function.Consumer
  - `void accept(T t)`
  - takes an argument (which is an element in the stream), and does some work, but does not return any value (void).
  - one of the many terminal operations.
  - Some of the Stream functions that accept a Consumer are:
    1. forEach (terminal function, return type of forEach is void)
    1. forEachOrdered
    1. peek (stream function, as the return type is Stream)
- java.util.Comparator
  - `int compare(T t1, T t2)`
  - example:
    - `(a, b)-> b-a` // for integers
    - `(a, b) -> Double.compare(b, a)` // for double
    - `(e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())` // employee salary
  - takes two elements of the stream and returns negative, zero or positive for `t1<t2`, `t1==t2` and `t1>t2` respectively
  - brings order between two elements
  - min, max, sorted are functions of Stream that take Comparator
- java.util.function.Function
  - `R apply(T t)`
  - Here `R` is the modified or derived version of `t`
  - Example, suppose in a stream of strings, we want the string to be transformed into uppercase,
    - `(str) -> str.toUpperCase()`
  - Another example, suppose in a stream of integers, for every integer, we want double the value of an element:
    - `n -> 2*n`
  - One more example, suppose we have a stream of elements, where each element represents the radius of a circle, and we want the area of the circle,
    - `r -> Math.PI * r * r`
  - this functional interface is an argument for the following methods of Stream:
    - `map`
    - `flatMap`
