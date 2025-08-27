package com.samit.searching;

public class SearchInAnInfiniteSortedArray {

    public static void main(String[] args) {
        int[] arr={20,40,100,300};
        int x=50;
        int index=searchInInfiniteSortedArr(arr,x);
        System.out.println(index);
    }

    static int searchInInfiniteSortedArr(int[] arr,int x){
        int low=0;
        int high=1;
        while (true){
            if (x>arr[high]){
                low=high;
                high=high*2;
            }else if (x<=arr[high]){
                break;
            }
        }
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]==x){
                return mid;
            }else if (x>arr[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
