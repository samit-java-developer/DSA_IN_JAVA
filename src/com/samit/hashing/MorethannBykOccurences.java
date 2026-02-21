package com.samit.hashing;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MorethannBykOccurences {

    public static void main(String[] args) {
        int[] arr={10,20,30,10,10,20,20};
        int k=3;
        long start=System.currentTimeMillis();
        printMoreThanNByK(arr,k);
        System.out.println();
        printMoreThanNByK(arr,k);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        start=System.currentTimeMillis();
        efficient(arr,k);
        end=System.currentTimeMillis();
        System.out.println(end-start);
        start=System.currentTimeMillis();
        printMoreEfficient(arr,k);
        end=System.currentTimeMillis();
        System.out.println(end-start);
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

    static void printViaNaive(int[] arr,int k){
        Arrays.sort(arr);
        int i=1,count=1;
        int n=arr.length;
        while (i<n){
            while(i<n && arr[i]==arr[i-1]){
                count++;
                i++;
            }
            if (count>n/k){
                System.out.print(arr[i-1]+" ");
            }
            count=1;
            i++;
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
        System.out.println();
        for (Map.Entry<Integer,Integer> entry:hashTable.entrySet()){
            if (entry.getValue()>n/k){
                System.out.print(entry.getKey()+" ");
            }
        }
    }

    static void printMoreEfficient(int[] arr,int k){
        int n=arr.length;
        Map<Integer,Integer> hashTable=new LinkedHashMap<>();
        for (int x:arr){
            if (hashTable.containsKey(x)){
                hashTable.put(x, hashTable.get(x)+1);
            } else if (hashTable.size()<k-1) {
                hashTable.put(x,1);
            }else{
                for(int key:hashTable.keySet()){
                    hashTable.put(key,hashTable.get(key)-1);
                    if (hashTable.get(key)==0){
                        hashTable.remove(key);
                    }
                }
            }
        }
        for (int x:hashTable.keySet()){
            int count=0;
            for (int i=0;i<n;i++){
                if (x==arr[i]){
                    count++;
                }
            }
            if (count>n/k){
                System.out.print(x+" ");
            }
        }
    }
}
