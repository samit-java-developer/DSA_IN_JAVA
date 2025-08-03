package com.samit.array.test;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr={10,5,8,0,0,10,0};
        System.out.println(Arrays.toString(arr));
        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
        zerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
        zerosToEnd2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void zerosToEnd(int[] arr){
        int index=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                arr[index++]=arr[i];
            }
        }
        while (index<arr.length){
            arr[index]=0;
            index++;
        }
    }
    static void zerosToEnd2(int[] arr){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                swap(arr,i,count);
                count++;
            }
        }
    }
    static void moveZerosToEnd(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            while (start<end && arr[start] != 0) start++;
            while (start<end && arr[end] == 0) end--;
            swap(arr, start, end);
        }
    }
    static void swap(int[] arr,int start,int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
