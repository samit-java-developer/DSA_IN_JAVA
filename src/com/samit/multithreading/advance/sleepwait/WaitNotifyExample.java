package com.samit.multithreading.advance.sleepwait;

class SharedResource {
    synchronized void waitExample() {
        System.out.println(Thread.currentThread().getName() + " is waiting...");
        try {
            wait(); // Releases the lock and waits
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " resumed after notify.");
    }

    synchronized void notifyExample() {
        System.out.println("Notifying a waiting thread...");
        notify(); // Wakes up one waiting thread
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedResource sharedResource=new SharedResource();
        Thread t1=new Thread(sharedResource::waitExample,"Thread-1");

        Thread t2=new Thread(()->{
            try {
                Thread.sleep(2000); // Ensure Thread-1 goes to wait state
                sharedResource.notifyExample();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread-2");
        t1.start();
        t2.start();
    }
}
