package com.samit.sorting;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr={9,0,2,1};
        cycleSortDistinct(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void cycleSortDistinct(int[] arr,int n){
        for(int cs=0;cs<n-1;cs++){
            int item=arr[cs];
            int pos=cs;
            for (int i=cs+1;i<n;i++){
                if (arr[i]<item){
                    pos++;
                }
            }
            swap(arr,cs,pos);
            item=arr[cs];
            while (pos!=cs){
                pos=cs;
                item=arr[cs];
                for (int i=cs+1;i<n;i++){
                    if(arr[i]<item){
                        pos++;
                    }
                }
                swap(arr,cs,pos);
            }
        }
    }

     static void swap(int[] arr,int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
