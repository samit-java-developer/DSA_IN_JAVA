package com.samit.multithreading;

public class DaemonThread extends Thread{
   //  When the JVM exits, all daemon threads are terminated
    @Override
    public void run(){
        for (int i=0;i<1000;i++) {
            System.out.println(Thread.currentThread().getName()+" Hello World! ");
        }
    }

    public static void main(String[] args) {
        DaemonThread t1=new DaemonThread();
        t1.setDaemon(true);
        DaemonThread t2=new DaemonThread();
        t2.start();
        t1.start();
        System.out.println("Main done");
    }

}

//Key Points
//Daemon thread (t1)
//
//JVM does not wait for daemon threads to finish once all user (non-daemon) threads are done.
//
//That means if t2 (the normal thread) and main finish, the JVM kills t1 immediately, even if it hasn’t completed its loop.
//
//User thread (t2)
//
//This one must finish before JVM can exit.
//
//JVM will keep running until t2 completes.
//
//        Main thread (main)
//
//Just prints "Main done" and finishes.
//
//        After that, only t1 (daemon) and t2 (user) are running.
