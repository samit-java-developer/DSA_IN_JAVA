package com.samit.multithreading.advance.threadsynchronization;

public class CounterSyncMethod {
    final Object lock=new Object();
    private int count=0;

    public void increment(){
        synchronized (lock){
            count++;
        }
    }
    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CounterSyncMethod counter=new CounterSyncMethod();
        int numberOfThreads=10;
        Thread[] threads=new Thread[numberOfThreads];
        for (int i=0;i<numberOfThreads;i++){
            threads[i]=new Thread(()->{
                for (int k=0;k<10000;k++){
                    counter.increment();
                }
            },"Thread-"+(i+1));
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final counter value: " + counter.getCount());
    }
}
