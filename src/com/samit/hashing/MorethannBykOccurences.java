package com.samit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MorethannBykOccurences {

    public static void main(String[] args) {
        int[] arr={10,20,30,10,10,20,20};
        int k=3;
        printMoreThanNByK(arr,k);
        System.out.println();
        efficient(arr,k);
    }

    static void printMoreThanNByK(int[] arr,int k){
        int count=1;
        int i=1;
        int n=arr.length;
        Arrays.sort(arr);
        while (i<n){
            while (i<n && arr[i]==arr[i-1]){
                count++;
                i++;
            }
            if (count>n/k){
                System.out.print(arr[i-1]+" ");
            }
            i++;
            count=1;
        }
    }

    static void efficient(int[] arr,int k){
        Map<Integer,Integer> hashTable=new LinkedHashMap<>();
        int n=arr.length;
        for (int x:arr){
            hashTable.put(x,hashTable.getOrDefault(x,0)+1);
        }
        for (int x:hashTable.keySet()){
            if (hashTable.get(x)>n/k){
                System.out.print(x+" ");
            }
        }
    }
}
