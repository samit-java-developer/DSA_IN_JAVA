package com.samit.sorting;

import java.util.Arrays;

public class SortAnArrayWithThreeTypes {
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,2};
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
        sortArrThreeTypes(arr);
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("---------------------");
        arr=new int[]{10,5,6,3,20,9,40};
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
        sortArrThreeTypesInRange(arr,5,10);
        Arrays.stream(arr).forEach(System.out::println);

    }
    static void sortArrThreeTypesInRange(int[] arr,int lowRange,int highRange){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int mid=0;
        while (mid<=high){
            if (arr[mid]<=lowRange){
                swap(arr,low++,mid++);
            } else if (arr[mid]<highRange) {
                mid++;
            }else if (arr[mid]>=highRange){
                swap(arr,mid,high--);
            }
        }
    }
    static void sortArrThreeTypes(int[] arr){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int mid=0;
        while (mid<=high){
            if (arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            }else{
                swap(arr,mid,high);
                high--;
            }
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
