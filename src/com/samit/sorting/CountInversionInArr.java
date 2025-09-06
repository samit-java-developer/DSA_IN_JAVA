package com.samit.sorting;

public class CountInversionInArr {

    public static void main(String[] args) {
       // int[] arr={2,4,1,3,5};
        int[] arr={40,30,20,10};
        int x=countInversionInArr(arr);
        System.out.println(x);
    }

    static int countInversionInArr(int[] arr){
        int n=arr.length;
        int count=0;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count;
    }

}
