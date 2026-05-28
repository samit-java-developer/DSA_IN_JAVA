package com.samit.mathematics.practice;

import java.util.Arrays;

public class Sieve {

    public static void main(String[] args) {
        int n=100;
        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr,true);
        for (int i=2;i*i<=n;i++){
            if (arr[i]){
                for (int j=i*i;j<=n;j=j+i){
                    arr[j]=false;
                }
            }
        }
        for (int i=2;i<=n;i++){
            if (arr[i]){
                System.out.print(i+" ");
            }
        }
    }
}
