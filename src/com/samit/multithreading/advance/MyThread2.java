package com.samit.multithreading.advance;

public class MyThread2 extends Thread{
    public void run(){
        throw new RuntimeException("Exception in thread");
    }

    public static void main(String[] args) {
        MyThread2 t1=new MyThread2();
        //t1.run();
        t1.start();
        System.out.println("Main thread is running....");
    }
}

