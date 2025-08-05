package com.samit.array;

import java.util.Arrays;

public class ReverseArrayInGroups {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(arr));
        int k=2;
        int previous=0;
        int next=k;
        int difference=k;
        do{
            swapTheArray(arr,previous,next-1);
            k=k+difference;
            previous=k-difference;
            next=k;
        }while(k<=arr.length);
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
