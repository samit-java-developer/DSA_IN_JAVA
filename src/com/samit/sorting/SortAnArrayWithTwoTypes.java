package com.samit.sorting;

import java.util.Arrays;

public class SortAnArrayWithTwoTypes {

    public static void main(String[] args) {
        int[] arr={15,-3,-2,18};
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
        sortAnArrNaive(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void sortAnArrNaive(int[] arr){
        int n=arr.length;
        int[] temp=new int[n];
        int i=-1;
        int j=n;
        while (true){
            do{
                i++;
            }while(arr[i]<0);
            do{
                j--;
            }while(arr[j]>=0);
            if (i>=j) return;
            swap(arr,i,j);
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
