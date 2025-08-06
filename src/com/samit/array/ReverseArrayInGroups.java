package com.samit.array;

import java.util.Arrays;

public class ReverseArrayInGroups {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5};
        int k=3;
        for (int i=0;i<arr.length;i=i+k){
            int end=i+k>arr.length?arr.length-1:(i+k)-1;
            swapTheArray(arr, i,end);
        }
        System.out.println(Arrays.toString(arr));
    }
    static void swapTheArray(int[] arr,int first,int last){
        while (first<last){
            swap(arr,first,last);
            first++;
            last--;
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
