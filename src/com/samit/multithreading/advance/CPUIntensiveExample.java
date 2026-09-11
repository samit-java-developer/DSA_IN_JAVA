package com.samit.multithreading.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task1 implements Runnable{
    private final String taskId;
    public Task1(String taskId) {
        this.taskId = taskId;
    }
    @Override
    public void run() {
        int result=CPUIntensiveExample.performComputation();
        System.out.println(this.taskId+" :: "+Thread.currentThread().getName() + " computed result: " + result);
    }
}

public class CPUIntensiveExample {
    private static final int NUM_CORES = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println(NUM_CORES);
        ExecutorService fixedThreadPool =Executors.newFixedThreadPool(NUM_CORES);
        for (int i=0;i<100;i++){
//            fixedThreadPool.execute(()->{
//                int result=performComputation();
//                System.out.println(Thread.currentThread().getName() + " computed result: " + result);
//            });
            fixedThreadPool.execute(new Task1((i+1)+""));
        }
        fixedThreadPool.shutdown();
    }

    public static int performComputation() {
        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += (int) Math.sqrt(i); // Simulating heavy computation
        }
        return sum;
    }
}
