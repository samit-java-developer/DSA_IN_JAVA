package com.samit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NByKOccurrences {

    public static void main(String[] args) {
        int[] arr={30,10,20,20,10,20,30,30};
        int k=4;
        printNByK(arr,k);
        System.out.println();
        efficient(arr,k);
    }

    static void printNByK(int[] arr,int k){
        int i=1;
        int count=1;
        int n=arr.length;
        Arrays.sort(arr);
        while (i<n){
            while (i<n && arr[i]==arr[i-1]){
                count++;
                i++;
            }
            if (count>(n/k)){
                System.out.print(arr[i-1]+" ");
            }
            count=1;
            i++;
        }
    }

    static void efficient(int[] arr,int k){
        //create and empty map.
        Map<Integer,Integer> maps=new HashMap<>();
        int n=arr.length;
        for (int i=0;i<n;i++){
            if (maps.containsKey(arr[i])){
                maps.put(arr[i],maps.getOrDefault(arr[i],0)+1);
            }else if (maps.size()<(k-1)){
                maps.put(arr[i],1);
            }else{
                maps=maps.entrySet().stream().filter(e->e.getValue()>=2).collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue()-1));
            }
        }
        for (Map.Entry<Integer,Integer> entry: maps.entrySet()){
            entry.setValue(0);
        }
        for (int x : arr) {
            if (maps.containsKey(x)) {
                maps.put(x, maps.getOrDefault(x, 0) + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry: maps.entrySet()){
            if (entry.getValue()>(n/k)){
                System.out.print(entry.getKey()+" ");
            }
        }
    }
}
