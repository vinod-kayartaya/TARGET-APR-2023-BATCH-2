package com.targetindia.programs;

import com.targetindia.threads.ExampleThread;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo1 {
    public static void main(String[] args) {
        log.trace("No. of threads currently active are {}", Thread.activeCount());
        log.trace("Name of the current thread is '{}'", Thread.currentThread().getName());

        ExampleThread t1, t2;
        t1 = new ExampleThread("FirstThread");  // t1 status is "new"
        t2 = new ExampleThread("SecondThread"); // t2 status is "new"

        log.trace("starting the thread t1");
        t1.start(); // t1 status is changed to "runnable"
        // t1 continues to execute its run() even after the main thread which is the parent for t1 ends.
        log.trace("started thread t1");
        log.trace("starting the thread t2");
        t2.start(); // t2 status is changed to "runnable"
        // t12 continues to execute its run() even after the main thread which is the parent for t2 ends.
        log.trace("started thread t2");
        log.trace("Reached the end of main()");
    }
}
