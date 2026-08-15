package com.samit.sorting;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr={319,212,6,8,100,50};
        //radixSort(arr,arr.length);
        arr=new int[]{319,212,6,8,100,50};
        radixSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
        // we use counting sort as subroutine in radix sort.....
        System.out.println("-------------------");
        arr=new int[]{319,212,6,8,100,50};
        System.out.println(Arrays.toString(arr));
        radixSortS(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void radixSort(int[] arr,int n){
        int mx=arr[0];
        for (int i=1;i<n;i++){
            mx=Math.max(arr[i],mx);
        }
        for (int exp=1;mx/exp>0;exp=exp*10){
            //countingSort(arr,n,exp);
            sortViaGivenDigit(arr,exp);
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

    static void sortViaGivenDigit(int[] arr,int exp){
        int[] count=new int[10];
        int n=arr.length;
        int[] output=new int[n];
        Arrays.fill(count,0);
        for (int x:arr){
            count[(x/exp)%10]++;
        }
        for (int i=1;i<10;i++){
            count[i]+=count[i-1];
        }
        for (int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        System.arraycopy(output,0,arr,0,n);
    }

    static void radixSortS(int[] arr){
        int max=Arrays.stream(arr).max().getAsInt();
        for (int exp=1;(max/exp)>0;exp=exp*10){
            countingSortForRadix(arr,exp);
        }
    }

    static void countingSortForRadix(int[] arr,int exp){
        int[] count=new int[10];
        int n=arr.length;
        Arrays.fill(count,0);
        for (int x:arr){
            count[(x/exp)%10]++;
        }
        for (int i=1;i<10;i++){
            count[i]=count[i]+count[i-1];
        }
        int[] output=new int[n];
        for (int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        int i=0;
        for (int x:output){
            arr[i++]=x;
        }
    }
}
