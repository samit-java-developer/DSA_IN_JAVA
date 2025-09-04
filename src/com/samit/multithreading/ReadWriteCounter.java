package com.samit.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteCounter {
    private int count=0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try{
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            writeLock.unlock();
        }
    }
    public int getCount(){
        readLock.lock();
        try{
            return count;
        }
        finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter=new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+":read "+counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.increment();
                }
            }
        };
        Thread writerThread = new Thread(writeTask,"Writer-First");
        Thread writerThread2 = new Thread(writeTask,"Writer-Second");
        Thread readerThread1 = new Thread(readTask,"Reader-First");
        Thread readerThread2 = new Thread(readTask,"Reader-Second");

        long start=System.currentTimeMillis();
        writerThread.start();
        writerThread2.start();
        readerThread1.start();
        readerThread2.start();

        writerThread.join();
        writerThread2.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final count: " + counter.getCount());
        long end=System.currentTimeMillis();
        System.out.println("Diff:: "+(int)(end-start));
    }
}
