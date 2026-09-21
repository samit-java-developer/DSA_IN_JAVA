package com.samit.multithreading.advance.semaphore;

import java.util.concurrent.Semaphore;

public class ReaderWriterLock {
    //Key Points to Remember:
    //✅ Choose the right collection based on your access patterns (read-heavy vs. write-heavy).
    //✅ ConcurrentHashMap is almost always preferred over Hashtable due to better performance.
    //✅ CopyOnWriteArrayList is ideal for rarely-modified, frequently-iterated lists.
    //✅ BlockingQueues are essential for producer-consumer patterns.
    //✅ Concurrent collections don't throw ConcurrentModificationException during iteration.
    private int readerCount=0;
    private final Semaphore mutex = new Semaphore(1);
    // Semaphore that allows writers (or the first reader) to acquire exclusive access.
    private final Semaphore wrt = new Semaphore(1);
    public void lockRead() throws InterruptedException {
        mutex.acquire();
        readerCount++;
        if (readerCount==1){
            wrt.acquire();
        }
        mutex.release();
    }

    public void unLockRead() throws InterruptedException {
        mutex.acquire();
        readerCount--;
        if (readerCount==0){
            wrt.release();
        }
        mutex.release();
    }

    public void lockWrite() throws InterruptedException {
        wrt.acquire();
    }

    public void unLockWrite() throws InterruptedException {
        wrt.release();
    }

    public static void main(String[] args) throws InterruptedException {
        ReaderWriterLock readerWriterLock=new ReaderWriterLock();
        Runnable readerTask=()->{
            try {
                readerWriterLock.lockRead();
                System.out.println(Thread.currentThread().getName()+" is reading");
                //Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+" finished reading");
                readerWriterLock.unLockRead();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable writerTask=()->{
            try {
                readerWriterLock.lockWrite();
                System.out.println(Thread.currentThread().getName()+" is writing");
                //Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+" finished writing");
                readerWriterLock.unLockWrite();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread reader1=new Thread(readerTask,"Reader-1");
        Thread reader2=new Thread(readerTask,"Reader-2");
        Thread reader3=new Thread(readerTask,"Reader-3");
        Thread reader4=new Thread(readerTask,"Reader-4");
        Thread writer1=new Thread(writerTask,"Writer-1");

        writer1.start();
        Thread.sleep(100);
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();

    }
}
