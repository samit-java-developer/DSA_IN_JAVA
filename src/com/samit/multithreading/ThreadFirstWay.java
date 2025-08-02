package com.samit.multithreading;
class World extends Thread{
    @Override
    public void run() {
        for(;;){
           System.out.println("World");
        }
    }
}


public class ThreadFirstWay {

    public static void main(String[] args) {
        World world=new World();
        world.start();
    }
}
