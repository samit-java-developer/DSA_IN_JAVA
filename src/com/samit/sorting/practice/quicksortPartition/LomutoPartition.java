package com.samit.sorting.practice.quicksortPartition;

import java.util.Arrays;

public class LomutoPartition {
    public static void main(String[] args) {
        // I always choose the last element as pivot
        int[] arr={1,4,5,7,8,2,3,6,9,2,3,5};
        System.out.println(Arrays.toString(arr));
        int x=findPivot(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(x);
    }
    static int findPivot(int[] arr,int low,int high){
        int pivot=arr[high];
        int n=arr.length;
        int i=low-1;
        for (int j=low;j<n-1;j++){
            if (arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return (i+1);
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
