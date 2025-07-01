package com.samit.array;

public class SlidingWindowTechnique {

    public static void main(String[] args) {
        int[] arr={1,8,30,-5,20,7};
        long start=System.currentTimeMillis();
        int res=maximumConsecutiveSubArraySumWithGivenK(arr,4);
        long end=System.currentTimeMillis();
        long time=end-start;
        System.out.println("Time taken by first :: "+time);
        System.out.println(res);
        start=System.currentTimeMillis();
        res=maximumConsecutiveSubArraySumWithGivenKefficient(arr,4);
        end=System.currentTimeMillis();
        time=end-start;
        System.out.println("Time taken by second :: "+time);
        System.out.println(res);
    }

    static int maximumConsecutiveSubArraySumWithGivenK(int[] arr,int k){
        int res=Integer.MIN_VALUE;
        for (int i=0;i+k-1<arr.length;i++){
            int curr=0;
            for (int j=i;j<i+k;j++){
                curr+=arr[j];
            }
            res=Math.max(res,curr);
        }
        return res;
    }

    static int maximumConsecutiveSubArraySumWithGivenKefficient(int[] arr,int k){
        int curr=0;
        for (int i=0;i<k;i++){
            curr+=arr[i];
        }
        int res=curr;
        for (int i=k;i<arr.length;i++){
            curr+=arr[i];
            curr-=arr[i-k];
            res=Math.max(res,curr);
        }
        return res;
    }
}
