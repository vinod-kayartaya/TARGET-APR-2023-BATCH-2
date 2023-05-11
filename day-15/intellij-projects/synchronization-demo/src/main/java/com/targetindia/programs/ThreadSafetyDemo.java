package com.targetindia.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreadSafetyDemo {

//    static void splitAndAddWords(List<String> list, String text) {
//        String[] words = text.split("\s+");
//        synchronized (list) {
//            for (String word : words) {
//                log.trace("thread {} is adding word '{}'", Thread.currentThread().getName(), word);
//                list.add(word);
//            }
//        }
//    }

    static synchronized void splitAndAddWords(List<String> list, String text) {
        String[] words = text.split("\s+");
        for (String word : words) {
            log.trace("thread {} is adding word '{}'", Thread.currentThread().getName(), word);
            list.add(word);
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        // shared data (across different threads)
        List<String> list = new ArrayList<>();
        String[] sentences = {
                "My name is Vinod and i live in Bangalore",
                "The quick brown Fox jumped over lazy Dog",
                "Java is a very powerful and popular Object Oriented Programming language"
        };

        List<Thread> threads = new ArrayList<>();

        for (String sentence : sentences) {
            Thread t = new Thread(() -> {
                log.trace("thread {} started work", Thread.currentThread().getName());
                splitAndAddWords(list, sentence);
                splitAndAddWords(list, sentence.toUpperCase());
                splitAndAddWords(list, sentence.toLowerCase());
                log.trace("thread {} finished work", Thread.currentThread().getName());
            });

            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            t.join();
        }

        log.trace("list = {}", list);
        log.trace("End of main reached! Bye.");
    }
}
