package com.synergistics.javacore;

public class Counter implements Runnable{

    volatile int number;

    public synchronized void incrementNumber(String name){
        System.out.println("Thread " + name + " increasing counter..." + (number +=1));

    }
    @Override
    public void run() {
        this.incrementNumber(Thread.currentThread().getName());
    }
}
