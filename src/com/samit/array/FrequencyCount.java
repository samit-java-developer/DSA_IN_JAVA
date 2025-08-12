package com.samit.array;

import java.util.ArrayList;
import java.util.List;

public class FrequencyCount {

    public static void main(String[] args) {
        int[] arr={3,3,3,3};
        List<Integer> res=frequencyCount(arr);
        System.out.println(res);
    }
    public static List<Integer> frequencyCount(int[] arr) {
        int n=arr.length;
        int[] freq=new int[n];
        for (int i=0;i<n;i++){
            freq[arr[i]-1]++;
        }
        List<Integer> resList=new ArrayList<>();
        for (int x: freq){
            resList.add(x);
        }
        return resList;
    }
}
