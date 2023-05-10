package com.targetindia.programs;

import lombok.SneakyThrows;

public class ThreadDemo3 {

    @SneakyThrows
    static void sleep(long duration) {
        Thread.sleep(duration);
    }

    public static void main(String[] args) {
        Runnable r;

        // body for the run() function, which is the ONLY abstract method in the Runnable interface
        r = () -> {
            for (int i = 0; ; i++) {
                System.out.printf("Inside the thread %s i is %s%n", Thread.currentThread().getName(), i);
                sleep(100);
            }
        };

        Thread t = new Thread(r, "RunnableThread"); // t.run() calls the r.run()
        t.setDaemon(true); // thread 't' terminates automatically, when there are no other non-daemon threads exist
        t.start();

        for (int i = 0; i < 50; i++) {
            System.out.printf("Inside the thread %s i is %s%n", Thread.currentThread().getName(), i);
            sleep(50);
        }

        // t.stop(); // deprecated
    }
}
