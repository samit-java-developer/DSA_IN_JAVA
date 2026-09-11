package com.samit.multithreading.advance.interthreadcommunication;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private final Queue<Integer> buffer=new LinkedList<>();
    private final int CAPACITY = 5;

    public void produce() throws InterruptedException {
        int value=0;
        while (true){
            synchronized (this){
                while (buffer.size()==CAPACITY){
                    System.out.println("Buffer is full. Producer is waiting...");
                    wait();
                }
                System.out.println("Producer produced: " + value);
                buffer.offer(value++);
                notifyAll();
            }
            Thread.sleep(1000);
        }
    }
    public void consume() throws InterruptedException {
        while (true){
            synchronized (this){
                while (buffer.isEmpty()){
                    System.out.println("Buffer is empty. Consumer is waiting...");
                    wait();
                }
                int value=buffer.poll();
                System.out.println("Consumer consumed: " + value);
                notifyAll();
            }
            Thread.sleep(1500);
        }
    }
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread producerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Producer thread interrupted.");
                }
            }
        }, "ProducerThread");

        Thread consumerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Consumer thread interrupted.");
                }
            }
        }, "ConsumerThread");
        producerThread.start();
        consumerThread.start();
    }
}
