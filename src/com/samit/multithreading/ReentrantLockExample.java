package com.samit.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final Lock lock= new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer Method !...");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inner Method !...");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantLockExample example=new ReentrantLockExample();
        example.outerMethod();

//        Acquires the lock, blocking the current thread until the lock is available. It would block the thread until the lock becomes available, potentially leading to situations where a thread waits indefinitely.
//        If the lock is already held by another thread, the current thread will wait until it can acquire the lock.
   }
}
