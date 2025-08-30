package com.samit.multithreading;

public class SynchronisationCountStatic {

    static int count=0;

    static synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
        Thread t1=new Thread(()-> {
            for (int i=0;i<10000;i++){
                SynchronisationCountStatic.increment();
            }
        });
        Thread t2=new Thread(()-> {
            for (int i=0;i<10000;i++){
                SynchronisationCountStatic.increment();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join(); //main thread will not proceed ahead until t1 is not completed their work.
            t2.join();  //main thread will not proceed ahead until t2 is not completed their work.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(SynchronisationCountStatic.count);
    }
}
