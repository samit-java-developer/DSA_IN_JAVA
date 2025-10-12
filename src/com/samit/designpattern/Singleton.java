package com.samit.designpattern;

public class Singleton {

    private static Singleton instance;

    private Singleton(){
        System.out.println("Connecting to database..");
    }

    public static Singleton getInstance(){
        if (instance==null){
            instance=new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton sg1=Singleton.getInstance();
        Singleton sg2=Singleton.getInstance();
        System.out.println(sg1==sg2);
    }
}
