package com.samit.multithreading.advance.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class Task implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i+" ");
        }
    }
}

public class ExecutorExample {

    public static void main(String[] args) {
        Executor executor = (Runnable command) -> {
            new Thread(command).start();
        };

        Executors.newFixedThreadPool(3);
        executor.execute(new Task());
    }
}
