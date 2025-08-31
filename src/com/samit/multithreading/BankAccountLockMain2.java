package com.samit.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount3{
    private int balance=1000;
    private final Lock lock=new ReentrantLock();

    public int getBalance(){
        return balance;
    }

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        lock.lock();
        try{
            if (balance>=amount){
                try{
                    System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                } catch (Exception e) {
                        Thread.currentThread().interrupt();
                }
            }else{
                System.out.println("Insufficient balance...");
            }
        }finally {
            lock.unlock();
        }
    }
}

public class BankAccountLockMain2 {

    public static void main(String[] args) throws InterruptedException {
        BankAccount3 bankAccount3=new BankAccount3();
        Runnable task=()->{
            bankAccount3.withdraw(50);
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");
        Thread t4 = new Thread(task, "Thread 4");
        Thread t5 = new Thread(task, "Thread 5");
        Thread t6 = new Thread(task, "Thread 6");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        System.out.println(bankAccount3.getBalance());
    }
}
