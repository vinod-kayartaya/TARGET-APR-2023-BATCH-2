package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog extends Animal{
    //@Override // hides the visibility of the inherited method
    public void talk() {
        log.trace("Dog is barking...");
    }
}
