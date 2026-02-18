package com.samit.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr={1,4,4,1,0,1};
        int k=10;
        countingSort(arr,k);
        System.out.println(Arrays.toString(arr));
        arr=new int[]{1,4,4,1,0,1};
        countingSortGeneralPurpose(arr,k);
        System.out.println(Arrays.toString(arr));
        arr=new int[]{1,4,4,1,0,1};
        countingSort2(arr);
        System.out.println(Arrays.toString(arr));
        arr=new int[]{1,4,4,1,0,1};
        countingSortGeneralPurpose(arr);
        System.out.println(Arrays.toString(arr));
    }
    // this would not work to sort the objects.
    static void countingSort(int[] arr, int k) {
        int[] count = new int[k];
        int n = arr.length;
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= count[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    static void countingSortGeneralPurpose(int[] arr, int k) {
        int[] count = new int[k];
        int n = arr.length;
        Arrays.fill(count, 0);
        for (int x : arr) {
            count[x]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }


    static void countingSort2(int[] arr){
        int maxEle=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            maxEle=Math.max(maxEle,arr[i]);
        }
        int[] count=new int[maxEle+1];
        for (int x: arr){
            count[x]++;
        }
        int index=0;
        for (int i=0;i<maxEle+1;i++){
            for (int j=1;j<=count[i];j++) {
                arr[index++]=i;
            }
        }
    }

    static void countingSortGeneralPurpose(int[] arr){
        int maxEle=Integer.MIN_VALUE;
        int n=arr.length;
        int[] output=new int[n];
        for (int i=0;i<arr.length;i++){
            maxEle=Math.max(maxEle,arr[i]);
        }
        int[] count=new int[maxEle+1];
        for (int x: arr){
            count[x]++;
        }
        for (int i=1;i<count.length;i++){
            count[i]=count[i-1]+count[i];
        }
        for (int i=n-1;i>=0;i--){
            output[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(output,0,arr,0,n);
    }


}
