package com.samit.bitmagic;

public class TestBit {
    public static void main(String[] args) {
        int n=7;
        int count=0;
        while (n>0){
            count+=n&1;
            n=n/2;
        }
        System.out.println(count);
    }
}
