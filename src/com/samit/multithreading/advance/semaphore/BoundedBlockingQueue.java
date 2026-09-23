package com.samit.multithreading.advance.semaphore;

import java.util.concurrent.*;

public class BoundedBlockingQueue {
    //Semaphore to track the number of items in the queue (full spots)
    private final Semaphore full;
    private final Semaphore empty;
    private final ConcurrentLinkedDeque<Integer> deque;

    public BoundedBlockingQueue(int capacity){
        full=new Semaphore(0);
        empty=new Semaphore(capacity);
        deque=new ConcurrentLinkedDeque<>();
    }

    public void enqueue(int element) throws InterruptedException {
        empty.acquire();
        deque.addFirst(element);
        full.release();
    }

    public int dequeue() throws InterruptedException {
        int res=-1;
        full.acquire();
        try{
            res=deque.pollLast();
        } catch (Exception e) {
            System.out.println(e);
        }
        empty.release();
        return res;
    }

    public int size(){
        return deque.size();
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingQueue queue=new BoundedBlockingQueue(5);
        int noOfProducers=3;
        int noOfConsumer=3;
        ExecutorService executors= Executors.newFixedThreadPool(noOfProducers+noOfConsumer);
        for (int p=1;p<=noOfProducers;p++){
            final int producerId=p;
            executors.submit(()->{
                try{
                    for (int i=1;i<=5;i++){
                        int value = producerId * 100 + i;
                        queue.enqueue(value);
                        System.out.println(
                                "Producer-" + producerId +
                                        " produced: " + value +
                                        " | queue size: " + queue.size()
                        );
                        //Thread.sleep(500);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        for (int c=1;c<=noOfConsumer;c++){
             final int consumerId=c;
             executors.submit(()->{
                 try{
                     for (int i=1;i<=5;i++){
                         int value=queue.dequeue();
                         System.out.println(
                                 "Consumer-" + consumerId +
                                         " consumed: " + value +
                                         " | queue size: " + queue.size()
                         );
                         //Thread.sleep(1000);
                     }
                 } catch (Exception e) {
                     throw new RuntimeException(e);
                 }
             });
        }
        executors.shutdown();
        if (executors.awaitTermination(30, TimeUnit.SECONDS)){
            executors.shutdownNow();
        }
        System.out.println(queue.deque.pollLast());
        System.out.println("All tasks completed.");
    }
}
