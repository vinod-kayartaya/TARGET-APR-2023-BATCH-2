package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat extends Animal{
    //@Override
    public void talk() {
        log.trace("CAt is meowing...");
    }
}
