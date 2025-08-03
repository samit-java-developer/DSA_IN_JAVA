package com.samit.array.test;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr={1,2,-7,0,2,3};
        int result=arr[0];
        for (int i=0;i<arr.length;i++) {
            int curr=arr[i];
            result=Math.max(result,curr);
            for (int j=i+1;j<arr.length;j++) {
                curr+=arr[j];
                result=Math.max(result,curr);
            }
        }
        System.out.println(result);
        int maxSubArray=maxEndingEfficient(arr);
        System.out.println(maxSubArray);
    }

    static int maxEndingEfficient(int[] arr) {
        int max=arr[0];
        int maxEnding=arr[0];
        for (int i=1;i<arr.length;i++) {
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);
            max=Math.max(max,maxEnding);
        }
        return max;
    }
}
