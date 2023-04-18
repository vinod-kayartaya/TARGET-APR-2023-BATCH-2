package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lion extends Animal{
    @Override
    public void talk() {
        log.trace("Lion is roaring...");
    }
}
