package com.targetindia.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.targetindia.dao"})
public class AppConfig2 {
    // in this configuration file, we do not have any bean definitions.
    // but, we have asked spring to scan one or more packages (and their sub-packages)
    // for classes that are marked as components (@Component, @Service, @Controller, @RestController
    // @Repository, @Configuration), and load objects of those classes (components)
    // into the spring container
}
