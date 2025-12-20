package com.samit.sorting;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr={319,212,6,8,100,50};
        radixSort(arr,arr.length);

    }
    static void radixSort(int[] arr,int n){
        int mx=arr[0];
        for (int i=1;i<n;i++){
            mx=Math.max(arr[i],mx);
        }
        for (int exp=1;mx/exp>0;exp=exp*10){
            countingSort(arr,n,exp);
            System.out.println(Arrays.toString(arr));
        }
    }

    static void countingSort(int[] arr,int n,int exp){
        int[] count=new int[10];
        Arrays.fill(count,0);
        int[] output=new int[n];
        for (int i=0;i<n;i++){
            count[(arr[i]/exp)%10]++;
        }
        for(int i=1;i<10;i++){
            count[i]=count[i-1]+count[i];
        }
        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}
