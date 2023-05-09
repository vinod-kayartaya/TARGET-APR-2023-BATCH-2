# Unit testing in Java

- A unit in most programming languages is a function
- A unit test ensures that the given function/method works as per the expectations for any variety of inputs
- JUnit is the most popular unit testing framework for Java
    - others: Cucumber, TestNG
    - current version of JUnit is 5.9.3. (just called as Junit5)

## JUnit 5 Components
- JUnit Platform (is launched on JVM, and interprets the test cases)
- JUnit Jupiter (brings new programming model, and has new annotations for defining the test environment)
- JUnit Vintage (supports the execution older APIs i.e, Junit version 3 and 4 on the new platform)

### JUnit 5 maven dependencies

```xml
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.junit.platform/junit-platform-runner -->
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-runner</artifactId>
    <version>1.9.3</version>
    <scope>test</scope>
</dependency>
```