package com.samit.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount{
    private int balance=1000;
    private final Lock lock=new ReentrantLock();
    public int getRemainingBalance(){
        return balance;
    }
    public void withdrawAmount(int amount){
        int count=0;
        boolean withdrawl=false;
        while (count<3 && !withdrawl){
            System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
            try {
                if (lock.tryLock()){
                    if (amount<=balance){
                        try {
                            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                            //Thread.sleep(100); // Simulate time taken to process the withdrawal
                            balance -= amount;
                            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                        } finally {
                            lock.unlock();
                            withdrawl=true;
                            count++;
                        }
                    }else{
                        System.out.println("Insufficient balance");
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}

public class SynchronizationViaLock {

    public static void main(String[] args) throws InterruptedException {
        BankAccount sbi=new BankAccount();
        Runnable task=()->{
            sbi.withdrawAmount(50);
        };
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        int remainingBalance=sbi.getRemainingBalance();
        System.out.println(remainingBalance);
    }
}
