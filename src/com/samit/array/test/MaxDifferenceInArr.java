package com.samit.array.test;

public class MaxDifferenceInArr {
    public static void main(String[] args) {
        int[] arr = {  2, 3, 10 ,6,4,8,1};
        int res=maxDifference(arr);
        System.out.println(res);
        res=maxDifferenceEfficient(arr);
        System.out.println(res);
    }

    static int maxDifference(int[] arr) {
        int res = arr[1]-arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                res=Math.max(res,arr[j]-arr[i]);
            }
        }
        return res;
    }

    static int maxDifferenceEfficient(int[] arr) {
        int res = -1;
        int min = arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            res=Math.max(res,arr[i]-min);
            min=Math.min(min,arr[i]);
        }
        return res;
    }
}
