package com.samit.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        // k is the no of buckets.
        int[] arr={30,40,10,80,5,12,70};
        int k=4;
        bucketSort(arr,k,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void bucketSort(int[] arr,int k,int n) {
        int maxValue = arr[0];
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        maxValue++;
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<k;i++){
            buckets.add(new ArrayList<>());
        }
        for (int i=0;i<n;i++){
            int bucketIndex=(k*arr[i])/maxValue;
            buckets.get(bucketIndex).add(arr[i]);
        }
        for(int i=0;i<k;i++){
            if (!buckets.get(i).isEmpty()){
                Collections.sort(buckets.get(i));
            }
        }
        int index=0;
        for(int i=0;i<k;i++){
            for (int j=0;j<buckets.get(i).size();j++){
                arr[index++]=buckets.get(i).get(j);
            }
        }
    }
}
