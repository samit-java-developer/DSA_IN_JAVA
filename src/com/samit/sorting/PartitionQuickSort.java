package com.samit.sorting;

import java.util.Arrays;

public class PartitionQuickSort {

    public static void main(String[] args) {
        int[] arr={5,13,6,9,12,11,8};
        System.out.println(Arrays.toString(arr));
        partitionNaive(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
        arr= new int[]{10,80,30,90,40,50,70};
        System.out.println(Arrays.toString(arr));
        int index=getPivotViaLoMuTo(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(index);
    }

    static void partitionNaive(int[] arr, int h){
        int[] temp=new int[h +1];
        int pivot=arr[h];
        int k=0;
        for (int i = 0; i<=h; i++){
            if (arr[i]<pivot && i!= h){
                temp[k++]=arr[i];
            }
        }
        temp[k++]=arr[h];
        for (int i = 0; i<=h; i++){
            if (arr[i]>pivot){
                temp[k++]=arr[i];
            }
        }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    static int getPivotViaLoMuTo(int[] arr){
        // In this algorithm always consider pivot is last value
        int l=0;
        int h=arr.length-1;
        int i=-1;
        for (int j=l;j<=h-1;j++){
            if (arr[j]<arr[h]){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return (i+1);
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
