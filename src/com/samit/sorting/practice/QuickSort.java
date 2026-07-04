package com.samit.sorting.practice;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
          int[] arr={87,23,65,43,89,10,34};
          Arrays.stream(arr).boxed().forEach(x->System.out.print(x+" "));
          quickSort(arr,0,arr.length-1);
          System.out.println("\n-----------------");
          Arrays.stream(arr).boxed().forEach(x->System.out.print(x+" "));
          arr=new int[]{87,23,65,43,89,10,34};
          Arrays.stream(arr).boxed().forEach(x->System.out.print(x+" "));
          System.out.println("\n--------------applied lomto... ---");
          quickSortL(arr,0,arr.length-1);
          Arrays.stream(arr).boxed().forEach(x->System.out.print(x+" "));
    }

    public static void quickSort(int[] arr,int l,int h){
        if (l<h){
            int p=naivePartition(arr,l,h);
            quickSort(arr,l,p-1);
            quickSort(arr,p+1,h);
        }
    }

    public static void quickSortL(int[] arr,int l,int h){
        if (l<h){
            int p=lomToPartition(arr,l,h);
            quickSortL(arr,l,p-1);
            quickSortL(arr,p+1,h);
        }
    }

    private static int naivePartition(int[] arr, int l, int h) {
        int[] temp=new int[(h-l)+1];
        int p=arr[h];
        int index=0;
        int res=-1;
        for (int i=l;i<=h;i++){
            if (arr[i]<=p && i!=h) {
                temp[index] = arr[i];
                index++;
            }
        }
        temp[index]=p;
        res=l+index;
        index++;
        for (int i=l;i<=h;i++){
            if (arr[i]>p) {
                temp[index] = arr[i];
                index++;
            }
        }
        for (int i=0;i<temp.length;i++){
            arr[l+i]=temp[i];
        }
        return res;
    }

    private static int lomToPartition(int[] arr,int l,int h){
        int pivot=arr[h];
        int i=l-1;
        for (int j=l;j<=h-1;j++){
            if (arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return (i+1);
    }

    static void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
