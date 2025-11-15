package com.samit.searching;

import java.util.Arrays;

public class FloorInSortedArray {
//(Imp questions....)
    public static void main(String[] args) {
        String input="4 15 17 17 19 20 21 22 22 25 26 26 26 28 28 28 31 31 32 33 34 34 35 36 36 37 38 38 39 41 41 42 43 43 44 44 45 45 46 47 49 49 50 50 50 51 53 54 54 56 57 58 58 59 60 64 67 69 75 94";
        int[] arr= Arrays.stream(input.split(" ")).mapToInt(x->Integer.parseInt(x.trim())).toArray();
        int x=26;
        int res=floorInSortedArr(arr,x);
        System.out.println(res);
    }

    static int floorInSortedArr(int[] arr,int x){
        int low=0;
        int n=arr.length;
        int high=n-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if ((arr[mid]==x && mid==n-1) || (arr[mid]==x && arr[mid]!=arr[mid+1])){
                return mid;
            }else if (x>=arr[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }
}
