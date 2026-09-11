package com.samit.multithreading.advance;

class SafeLock {
    private final Object lock = new Object();
    void waitForSignal() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                lock.wait(3000); // Wait with a timeout to prevent leak
                //lock.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
} 
 
public class ThreadLeakExample { 
    public static void main(String[] args) { 
        SafeLock safeLock = new SafeLock();
        Runnable r1= safeLock::waitForSignal;
        new Thread(safeLock::waitForSignal, "WorkerThread2").start();
        new Thread(r1, "WorkerThread1").start();
    } 
}