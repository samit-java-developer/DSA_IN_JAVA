package com.samit.multithreading.advance.sleepwait;

public class SleepExample {
    public static void main(String[] args) {
        System.out.println("Thread is going to sleep...");
        try {
            Thread.sleep(2000); // Sleep for 2 seconds // not releasing lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread woke up after sleeping.");
    }
}
