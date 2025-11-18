package com.samit.searching;

import java.util.Arrays;

public class MinimumNumberInSortedRotated {
    static class Solution {
        // Function to find the minimum element in sorted and rotated array.
        int minNumber(int arr[], int low, int high) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] < arr[high]) {
                    high = mid;      // include mid because it could be min
                } else {
                    low = mid + 1;   // mid cannot be min
                }
            }
            return arr[low];
        }

        int minNumber3(int arr[], int low, int high) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[low]<arr[high]){
                    return arr[low];
                }
                if (arr[low] <= arr[mid]) {
                    low=mid+1;
                } else {
                    high=mid;
                }
            }
            return arr[low];
        }


        int minNumber2(int arr[], int low, int high){
            int n=high-low+1;
            while (low<high){
                int mid=low+(high-low)/2;
                if (arr[low]<arr[high]){
                    return arr[low];
                }
                if ((mid==0 && arr[mid]<arr[mid+1]) || (mid!=0 && mid!=n-1 && arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]) || (mid==n-1 && arr[mid]<arr[mid-1])){
                    return arr[mid];
                }
                if (arr[low]<=arr[mid]){
                    low=mid+1;
                }else{
                    high=mid;
                }
            }
            return arr[low];
        }
    }

    public static void main(String[] args) {
        int[] arr={2,3,4,5,6,7,8,9,10,1};
        String input="32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31";
        arr=Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int x=new MinimumNumberInSortedRotated.Solution().minNumber3(arr,0,arr.length-1);
        System.out.println(x);
    }
}
