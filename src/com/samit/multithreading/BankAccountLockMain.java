package com.samit.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount2{
    private int balance=100;
    private final Lock lock=new ReentrantLock();

    public int getBalance(){
        return balance;
    }

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try{
            if (lock.tryLock()){
                if (balance>=amount){
                    try{
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                }else{
                    System.out.println("Insufficient balance...");
                }
            }else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BankAccountLockMain {

    public static void main(String[] args) throws InterruptedException {
        BankAccount2 bankAccount2=new BankAccount2();
        Runnable task=()->{
            bankAccount2.withdraw(50);
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(bankAccount2.getBalance());
    }
}
