package com.samit.searching;

import java.util.Arrays;

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
        int[] res=findFirstAndLastOccurrence(arr,arr.length,x);
        System.out.println(Arrays.toString(res));
    }

    static int[] findFirstAndLastOccurrence(int[] arr,int n,int x){
        int[] result=new int[2];
        int low=0;
        int high=n-1;
        int first=0;
        int last=0;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (x>arr[mid]){
                low=mid+1;
            }else if (x<arr[mid]){
                high=mid-1;
            }else{
                if (mid==0 || arr[mid]!=arr[mid-1]){
                    first=mid;
                    break;
                }else{
                    high=mid-1;
                }
            }
        }
        low=0;
        high=n-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (x>arr[mid]){
                low=mid+1;
            }else if (x<arr[mid]){
                high=mid-1;
            }else{
                if (mid==n-1 || arr[mid]!=arr[mid+1]){
                    last=mid;
                    break;
                }else{
                    low=mid+1;
                }
            }
        }
        result[0]=first;
        result[1]=last;
        return result;
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
