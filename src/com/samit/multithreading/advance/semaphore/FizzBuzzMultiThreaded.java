package com.samit.multithreading.advance.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FizzBuzzMultiThreaded {
    private final Semaphore numberSemaphore=new Semaphore(1);
    private final Semaphore fizzSemaphore=new Semaphore(0);
    private final Semaphore buzzSemaphore=new Semaphore(0);
    private final Semaphore fizzBuzzSemaphore=new Semaphore(0);
    private final int n;

    public FizzBuzzMultiThreaded(int n){
        this.n=n;
    }

    public void printNumber() throws InterruptedException {
        for (int i=1;i<=this.n;i++){
            numberSemaphore.acquire();
            if (i%3==0 && i%5==0){
                fizzBuzzSemaphore.release();
            }else if (i%3==0){
                fizzSemaphore.release();
            }else if(i%5==0){
                buzzSemaphore.release();
            }else{
                System.out.print(i+" ");
                numberSemaphore.release();
            }
        }
    }

    public void printFizz() throws InterruptedException {
        for (int i=1;i<=n;i++){
            if (i%3==0 && i%5!=0){
                fizzSemaphore.acquire();
                System.out.print("fizz ");
                numberSemaphore.release();
            }
        }
    }

    public void printBuzz() throws InterruptedException {
        for (int i=1;i<=n;i++){
            if (i%5==0 && i%3!=0){
                buzzSemaphore.acquire();
                System.out.print("Buzz ");
                numberSemaphore.release();
            }
        }
    }
    public void printFizzBuzz() throws InterruptedException {
        for (int i=1;i<=n;i++){
            if (i%3==0 && i%5==0){
                fizzBuzzSemaphore.acquire();
                System.out.print("FizzBuzz ");
                numberSemaphore.release();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        FizzBuzzMultiThreaded fizzBuzzMultiThreaded=new FizzBuzzMultiThreaded(15);
        executorService.submit(()-> {
            try {
                fizzBuzzMultiThreaded.printNumber();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        executorService.submit(()-> {
            try {
                fizzBuzzMultiThreaded.printFizz();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        executorService.submit(()-> {
            try {
                fizzBuzzMultiThreaded.printBuzz();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        executorService.submit(()-> {
            try {
                fizzBuzzMultiThreaded.printFizzBuzz();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        executorService.shutdown();
        if (executorService.awaitTermination(2000, TimeUnit.MILLISECONDS)){
            executorService.shutdownNow();
        }
    }
}
