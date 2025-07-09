package com.samit.array;

public class SecondLargestElement {

    public static void main(String[] args) {
        int i=0,first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
        int[] arr={12,35,1,10,34,1};
        for (;i<arr.length;i++){
            if (first<arr[i]){
                second=first;
                first=arr[i];
            }else if (arr[i]<first && arr[i]>=second){
                second=arr[i];
            }
        }
        System.out.print(first);
        System.out.print(second);
    }
}
