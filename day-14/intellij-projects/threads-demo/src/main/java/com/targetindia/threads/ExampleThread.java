package com.targetindia.threads;

import lombok.SneakyThrows;

public class ExampleThread extends Thread {

    public ExampleThread() {
    }

    public ExampleThread(String name) {
        super(name);
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.printf("Thread name is '%s', and my name is '%s' and i is %d%n",
                    Thread.currentThread().getName(),
                    this.getName(),
                    i);
            Thread.sleep(100);
        }
    }
}
