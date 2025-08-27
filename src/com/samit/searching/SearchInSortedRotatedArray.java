package com.samit.searching;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr={100,500,10,20,30,40,50};
        int x=100;
        int index=searchInRotatedInArr(arr,x);
        System.out.println(index);
    }
    static int searchInRotatedInArr(int[] arr,int x){
        int n=arr.length;
        int low=0;
        int high=n-1;
        // one half is sorted compulsory
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]==x){
                return mid;
            }
            if (arr[low]<=arr[mid]){
                //left half is sorted
                if (x>=arr[low] && x<arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                //right half is sorted
                if (x>arr[mid] && x<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
