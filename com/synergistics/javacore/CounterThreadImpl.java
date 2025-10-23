package com.synergistics.javacore;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CounterThreadImpl {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter = new Counter();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {

            Future<?> f1 = executor.submit(counter);
            f1.get(); // Wait for task 1

            Future<?> f2 = executor.submit(counter);
            f2.get(); // Wait for task 2

            Future<?> f3 = executor.submit(counter);
            f3.get(); // Wait for task 3
        }

        executor.shutdown();
    }
}
