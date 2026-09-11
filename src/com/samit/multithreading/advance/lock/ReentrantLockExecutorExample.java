package com.samit.multithreading.advance.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExecutorExample {
    private int counter = 0;
    //private final Object lock = new Object();
    private final ReentrantLock lock = new ReentrantLock();
    //    public synchronized void increment() {
    //        for (int i = 0; i < 1000_00; i++) {
    //            counter++;
    //        }
    //    }
    public synchronized void increment() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            for (int i=0;i<1000_00;i++){
                counter++;
            }
            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        ReentrantLockExecutorExample example = new ReentrantLockExecutorExample();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(example::increment);
            // you can write above things in below-mentioned way lambda way
            //executorService.submit(()->{example.increment();});
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(6, TimeUnit.MILLISECONDS)) {
                System.out.println("Final counter value:: " + example.getCounter());
            } else {
                System.out.println("Timeout: Not all tasks finished.");
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting for tasks to finish.");
            Thread.currentThread().interrupt();
        }
    }
}
