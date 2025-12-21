package com.samit.hashing;

import java.util.Arrays;

public class HashingOpenAddressing implements Mandotrymethod{
    // linear probing.....
    final int[] arr;
    final int cap;
    int size;

    public HashingOpenAddressing(int c) {
        this.arr = new int[c];
        Arrays.fill(this.arr,-1);
        this.cap = c;
        this.size = 0;
    }
    int hash(int key){
        return key%this.cap;
    }
    @Override
    public boolean search(int key){
        int h=hash(key);
        int i=h;
        while (arr[i]!=-1){
            if (arr[i]==key) return true;
            i=(i+1)%cap;
            if (i==h){
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean insert(int key){
        if (size==cap){
            return false;
        }
        int i=hash(key);
        while (arr[i]!=-1 && arr[i]!=-2 && arr[i]!=key){
            i=(i+1)%cap;
        }
        if (arr[i]==key){
            return false;
        }else{
            arr[i]=key;
            size++;
            return true;
        }
    }
    @Override
    public boolean erase(int key){
        int h=hash(key);
        int i=h;
        while (arr[i]!=-1){
            if (arr[i]==key){
                arr[i]=-2;
                return true;
            }
            i=(i+1)%cap;
            if (i==h) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Mandotrymethod table=new HashingOpenAddressing(7);
        table.insert(49);
        table.insert(56);
        table.insert(72);
        if (table.search(56)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        table.erase(56);
        if (table.search(56)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
