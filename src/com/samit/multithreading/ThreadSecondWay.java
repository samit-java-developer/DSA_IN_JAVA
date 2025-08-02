package com.samit.multithreading;
class World1 implements Runnable{
    @Override
    public void run() {
        for(;;){
           System.out.println("World1");
        }
    }
}


public class ThreadSecondWay {

    public static void main(String[] args) {
        Runnable world=new World1();
        Thread t1=new Thread(world);
        t1.start();
    }
}
