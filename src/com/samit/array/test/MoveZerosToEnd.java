package com.samit.array.test;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr={10,5,8,0,0,10,0};
        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
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
