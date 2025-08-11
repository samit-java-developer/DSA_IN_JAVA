package com.samit.array;

import java.util.Arrays;

public class RearrangeArrayAlterNatively {
    public static void main(String[] args) {
        int[] arr={10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        int n=arr.length;
        int start=0;
        int end=n-1;
        int i=0;
        int max=arr[n-1]+1;
        while (start<=end){
            int endValue=arr[end]%max;
            int startValue=arr[start]%max;
            if (start!=end){
                arr[i]+=(endValue%max)*max;
                arr[i+1]+=(startValue%max)*max;
            }else{
                arr[i]+=(endValue%max)*max;
            }
            start++;
            end--;
            i+=2;
        }
        for (int j=0;j<n;j++){
            arr[j]=arr[j]/max;
        }
        System.out.println(Arrays.toString(arr));
    }
}
