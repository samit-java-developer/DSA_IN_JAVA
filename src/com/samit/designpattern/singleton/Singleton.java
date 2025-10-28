package com.samit.designpattern.singleton;

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

        //Here, sg1 and sg2 are both pointing to the same object, showing how Singleton avoids multiple object creation. This pattern is useful in logging, configuration classes, and connection pools.
    }
}
