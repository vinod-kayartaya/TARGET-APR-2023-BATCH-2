package com.targetindia.programs;

import com.targetindia.threads.ExampleThread;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo2 {

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new ExampleThread();

        log.trace("starting the thread {}", t1.getName());
        t1.setDaemon(true); // t1 will terminate as soon as the main thread terminates
        // setDaemon has to be called before the thread can be started

        t1.start();
        log.trace("thread {} started", t1.getName());
        log.trace("t1.isDaemon() is {}", t1.isDaemon());


        for (int i = 0; i < 50; i++) {
            System.out.printf("In main(), i is %d%n", i);
            Thread.sleep(50);
        }

        log.trace("End of main reached.");
    }
}

