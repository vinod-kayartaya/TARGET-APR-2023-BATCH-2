package com.targetindia.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLockSolutionDemo {
    // shared resources
    Object resource1 = new Object();
    Object resource2 = new Object();

    @SneakyThrows
    void doSomething(){
        log.trace("going to acquire lock on resource1 in doSomething()");
        synchronized (resource1){
            log.trace("acquired lock on resource1 in doSomething()");
            log.trace("going to acquire lock on resource2 in doSomething()");
            synchronized (resource2){
                log.trace("acquired lock on resource2 in doSomething()");
                log.trace("doing something for 5 seconds...pls wait");
                Thread.sleep(5000);
            }
            log.trace("released lock on resource2 in doSomething()");
        }
        log.trace("released lock on resource1 in doSomething()");
    }

    void doSomethingElse(){
        log.trace("going to acquire lock on resource1 in doSomethingElse()");
        synchronized (resource1){
            log.trace("acquired lock on resource1 in doSomethingElse()");
            log.trace("going to acquire lock on resource2 in doSomethingElse()");
            synchronized (resource2){
                log.trace("acquired lock on resource2 in doSomethingElse()");
            }
            log.trace("released lock on resource2 in doSomethingElse()");
        }
        log.trace("released lock on resource1 in doSomethingElse()");
    }

    public static void main(String[] args) {
        DeadLockSolutionDemo demo = new DeadLockSolutionDemo();

        new Thread(()->demo.doSomething()).start();
        new Thread(demo::doSomethingElse).start();
    }
}
