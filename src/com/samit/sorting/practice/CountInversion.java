package com.samit.sorting.practice;

public class CountInversion {

    public static void main(String[] args) {
        int[] arr={2, 3, 4, 5, 6};
        int res=mergeSort(arr,0,arr.length-1);
        System.out.println(res);
    }
    
    static int mergeSort(int[] arr,int low,int high){
        if (low<high){
            int mid=low+(high-low)/2;
            int x=mergeSort(arr,low,mid);
            int y=mergeSort(arr,mid+1,high);
            int z=merge(arr,low,mid,high);
            return x+y+z;
        }
        return 0;
    }

    static int merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid;
        int k=0;
        int count=0;
        while (i<=mid-1 && j<=high){
            if (arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                count+=(mid-i);
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid-1){
            temp[k++]=arr[i++];
        }
        while (j<=high){
            temp[k++]=arr[j++];
        }
        int tempi=0;
        for (int x=low;x<=high;x++){
            arr[x]=temp[tempi++];
        }
        return count;
    }
}

