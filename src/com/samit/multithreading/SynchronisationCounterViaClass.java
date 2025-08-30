package com.samit.multithreading;

class Counter{
    int count=0;
    public synchronized void increment(){
        count++;
    }
    public int getIncrement(){
        return count;
    }
}

public class SynchronisationCounterViaClass extends Thread {
    private Counter counter;

    public SynchronisationCounterViaClass(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            counter.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c1=new Counter();
        SynchronisationCounterViaClass t1=new SynchronisationCounterViaClass(c1);
        SynchronisationCounterViaClass t2=new SynchronisationCounterViaClass(c1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(c1.getIncrement());
    }
}
