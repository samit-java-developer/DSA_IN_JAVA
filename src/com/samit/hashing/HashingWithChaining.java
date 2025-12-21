package com.samit.hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashingWithChaining {

    final int BUCKET;
    final ArrayList<LinkedList<Integer>> table;

    public HashingWithChaining(int bucket) {
        BUCKET = bucket;
        this.table = new ArrayList<>();
        for(int i=0;i<bucket;i++){
            table.add(new LinkedList<>());
        }
    }
    void insert(int key){
        int index=key%BUCKET;
        table.get(index).add(key);
    }

    void remove(int key){
        int index=key%BUCKET;
        table.get(index).remove(key);
    }
    boolean search(int key){
        int index=key%BUCKET;
        return table.get(index).contains(key);
    }

    void print(){
        table.forEach(System.out::println);
    }

    public static void main(String[] args) {
        HashingWithChaining table=new HashingWithChaining(7);
        table.insert(50);
        table.insert(21);
        table.insert(58);
        table.insert(17);
        table.insert(15);
        table.insert(49);
        table.insert(56);
        table.insert(22);
        table.insert(23);
        table.insert(25);
        table.print();

    }

}
