package com.samit.multithreading.advance.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ZeroEvenOddProblem {
    private final Semaphore zeroSemaPhore;
    private final Semaphore evenSemaPhore;
    private final Semaphore oddSemaPhore;
    private final int n;

    public ZeroEvenOddProblem(int n) {
        this.zeroSemaPhore = new Semaphore(1);
        this.evenSemaPhore = new Semaphore(0);
        this.oddSemaPhore = new Semaphore(0);
        this.n = n;
    }

    public void printZero() throws InterruptedException {
        boolean isOdd=true;
        for (int i=1;i<=n;i++){
            zeroSemaPhore.acquire();
            System.out.print(0+"");
            if (isOdd){
                oddSemaPhore.release();
            }else{
                evenSemaPhore.release();
            }
            isOdd=!isOdd;
        }
    }

    public void printOdd() throws InterruptedException {
        for (int i=1;i<=n;i=i+2){
            oddSemaPhore.acquire();
            System.out.print(i);
            zeroSemaPhore.release();
        }
    }


    public void printEven() throws InterruptedException {
        for (int i=2;i<=n;i=i+2){
            evenSemaPhore.acquire();
            System.out.print(i);
            zeroSemaPhore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        ZeroEvenOddProblem zeroEvenOddProblem=new ZeroEvenOddProblem(5);
        executorService.submit(()-> {
            try {
                zeroEvenOddProblem.printZero();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        executorService.submit(()-> {
            try {
                zeroEvenOddProblem.printOdd();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        executorService.submit(()-> {
            try {
                zeroEvenOddProblem.printEven();
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
