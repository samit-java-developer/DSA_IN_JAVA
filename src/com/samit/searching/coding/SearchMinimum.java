package com.samit.searching.coding;

import java.util.Arrays;

public class SearchMinimum {

    public static void main(String[] args) {
        String line="32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31";
        String[] lineArr=line.split(" ");
        int[] arr=new int[lineArr.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(lineArr[i]);
        }
        System.out.println(Arrays.toString(arr));
        int x=minNumber(arr,0,arr.length-1);
        System.out.println(x);
    }


    static int minNumber(int arr[], int low, int high) {
        while (low<high){
            if (arr[low]<=arr[high]){
                return arr[low];
            }
            int mid=low+(high-low)/2;
            if (arr[mid]>=arr[low]){
                low=mid+1;
            }else{
                high=mid+1;
            }
        }
        return arr[low];
    }

}
