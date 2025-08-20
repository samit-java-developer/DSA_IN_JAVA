package com.samit.array;

import java.util.ArrayList;

public class SequenceNumber {
    public static void main(String[] args) {
        int n=10;
        ArrayList<Integer> res=pattern(n);
        for (int x:res){
            System.out.print(x+" ");
        }
    }
    public static ArrayList<Integer> pattern(int n) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if (n<0){
            list.add(n);
            return list;
        }
        int previous=n;
        while (n>0){
            list.add(n);
            n=n-5;
        }
        while (previous!=n){
            list.add(n);
            n=n+5;
        }
        list.add(previous);
        return list;
    }
}
