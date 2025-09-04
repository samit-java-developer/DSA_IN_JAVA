package com.samit.multithreading;

class SharedResource{
    private int data;
    private boolean hasData;

    public synchronized void produce(int value){
        while (hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.data=value;
        System.out.println("Produced: " + value);
        hasData=true;
        notify();
    }

    public synchronized int consume(){
        while (!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasData=false;
        System.out.println("Consumed :: "+this.data);
        notify();
        return data;
    }
}
class Producer implements Runnable{
    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource){
        this.sharedResource=sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource){
        this.sharedResource=sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int x=sharedResource.consume();
        }
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {
        SharedResource sharedResource=new SharedResource();
        Producer producer=new Producer(sharedResource);
        Consumer consumer=new Consumer(sharedResource);

        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
    }
}
