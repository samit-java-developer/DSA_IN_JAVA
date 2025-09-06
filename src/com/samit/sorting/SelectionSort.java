package com.samit.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr={2,3,4,1,8,9,3};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int min_index=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            swap(arr,min_index,i);
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
