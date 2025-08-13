package com.samit.array;

public class MaxWaterProblem {
    public static void main(String[] args) {
        int[] arr={3,0,1,0,4,0,2};
        int res=maxWater(arr);
        System.out.println(res);
        int x=10;
        int y=93;
        res=x-y;
        System.out.println(Math.abs(res));
    }

    public static int maxWater(int arr[]) {
        int n=arr.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        leftMax[0]=arr[0];
        rightMax[n-1]=arr[n-1];
        for (int i=1;i<n;i++){
            leftMax[i]=Math.max(arr[i],leftMax[i-1]);
        }
        for (int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(arr[i],rightMax[i+1]);
        }
        int maxWater=0;
        for (int i=1;i<n-1;i++){
            maxWater+=(Math.min(leftMax[i],rightMax[i])-arr[i]);
        }
        return maxWater;
    }
}
