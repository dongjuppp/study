package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static Integer fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
//        vmFunc();
//        ftFunc();
        oneThread(10000);
        long end = System.currentTimeMillis();
        System.out.println("Total execution time: " + (end - start));
//        int result = fibonacci(10);

//        System.out.println(result);
    }

    private static void oneThread(int time) throws InterruptedException {
        for(int i = 0; i< time; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void flatFormThreadFunc(int time) throws InterruptedException {
        try(ExecutorService es = Executors.newScheduledThreadPool(100)) {
            for(int i =  0; i< time; i ++) {
                es.submit(() -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }

    private static void virtualThreadFunc(int time) {
        try(ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i =  0; i< time; i ++) {
                es.submit(() -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }
}