package com.samit.array;

import java.util.Arrays;

public class RotateArr {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        rotateArr(arr,2);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateArr(int[] arr, int d) {
        int n=arr.length;
        swapArray(arr,0,d-1);
        swapArray(arr,d,n-1);
        swapArray(arr,0,n-1);
    }
    static void swapArray(int[] arr,int i, int j){
        while (i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
