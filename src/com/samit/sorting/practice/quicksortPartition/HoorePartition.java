package com.samit.sorting.practice.quicksortPartition;

import java.util.Arrays;

public class HoorePartition {
    public static void main(String[] args) {
        int[] arr={4,5,7,8,2,3};
        System.out.println(Arrays.toString(arr));
        int xx=findPartition(arr,0,arr.length-1);
        System.out.println(xx);
        System.out.println(Arrays.toString(arr));
    }

    static int findPartition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low-1;
        int j=high+1;
        while (true){
            do{
                i++;
            }while (arr[i]<pivot);
            do{
                j--;
            }while (arr[j]>pivot);
            if (i>=j){
                return j;
            }
            swap(arr,i,j);
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
