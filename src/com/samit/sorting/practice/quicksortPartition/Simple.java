package com.samit.sorting.practice.quicksortPartition;

import java.util.Arrays;

public class Simple {
    public static void main(String[] args) {
        int[] arr={1,4,5,7,8,2,3,6,9};
        System.out.println(Arrays.toString(arr));
        int x=findPivot(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(x);
    }

    static int findPivot(int[] arr, int high){
        int[] temp=new int[high +1];
        int index=0;
        int pivot=0;
        for (int i = 0; i<=high; i++){
            if (i!= 2){
                if (arr[i]<arr[2]){
                    temp[index++]=arr[i];
                }
            }
        }
        pivot=index;
        temp[index++]=arr[2];
        for (int i = 0; i<=high; i++){
            if (i!= 2){
                if (arr[i]>=arr[2]){
                    temp[index++]=arr[i];
                }
            }
        }
        int i=0;
        for (int x: temp){
            arr[i++]=x;
        }
        return pivot;
    }
}
