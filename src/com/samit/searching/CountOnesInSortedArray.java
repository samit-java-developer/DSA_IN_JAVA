package com.samit.searching;

public class CountOnesInSortedArray {

    public static void main(String[] args) {
        int[] arr={0,0,0};
        int n=arr.length;
        int diff=findOneOccurrence(arr,n);
        System.out.println(diff);
    }

    static int findOneOccurrence(int[] arr,int n){
        int low=0;
        int high=n-1;
        int index=0;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]==0){
                low=mid+1;
            }else{
                if (mid==0 || arr[mid]!=arr[mid-1]){
                    index=mid;
                    break;
                }else{
                    high=mid-1;
                }
            }
        }
        return n-index;
    }

}
