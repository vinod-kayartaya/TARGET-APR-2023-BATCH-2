package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Animal {

    // ensures that every concrete subclass has the talk() function
    public abstract void talk();
}
