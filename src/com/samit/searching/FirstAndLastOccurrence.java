package com.samit.searching;

public class FirstAndLastOccurrence {

    public static void main(String[] args) {
        int[] arr={5,10,10,15,15,15};
        int x=15;
        int firstIndex=findFirstOccurrence(arr,x);
        if (firstIndex!=-1){
            System.out.println(firstIndex);
        }else{
            System.out.println("NA");
        }

        int lastIndex=findLastOccurrence(arr,x);
        if (lastIndex!=-1){
            System.out.println(lastIndex);
        }else{
            System.out.println("NA");
        }

    }

    static int findFirstOccurrence(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=low+((high-low)/2);
            if ((mid==0 && arr[mid]==x)||(mid>=1 && arr[mid]==x && arr[mid-1]!=x)){
                return mid;
            }else if (x>arr[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    static int findLastOccurrence(int[] arr,int x){
        int low=0;
        int n=arr.length;
        int high=n-1;
        while (low<=high){
            int mid=low+((high-low)/2);
            if ((mid==n-1 && arr[mid]==x)||(mid+1<n && arr[mid]==x && arr[mid+1]!=x)){
                return mid;
            }else if (x>=arr[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

}
