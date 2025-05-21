package com.samit.array.test;

public class MaxiumSubArray {
    public static void main(String[] args) {
        int[] arr={1,2,-7,0,2,3};
        int result=arr[0];
        for (int i=0;i<arr.length;i++) {
            int curr=0;
            for (int j=i;j<arr.length;j++) {
                curr+=arr[j];
                result=Math.max(result,curr);
            }
        }
        System.out.println(result);
    }
}
