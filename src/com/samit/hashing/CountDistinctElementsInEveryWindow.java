package com.samit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDistinctElementsInEveryWindow {

    public static void main(String[] args) {
        int[] arr={10,20,20,10,30,40,10};
        int k=4;
        myApproach(arr,k);
    }
    static void myApproach(int[] arr,int k){
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.print(map.size()+" ");
        for (int i=k;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            map.put(arr[i-k],map.get(arr[i-k])-1);
            if (map.get(arr[i-k])==0){
                map.remove(arr[i-k]);
            }
            System.out.print(map.size()+" ");
        }

        //Arrays.stream(arr).boxed().collect(Collectors.toMap(Function.identity(),v->1, Integer::sum));

        //Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}
