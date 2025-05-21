package com.samit.array.test;

public class MaxEvenOddSubArray {

    public static void main(String[] args) {
        //int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr = {5,10,20,6,3,8};
        int res=maxEvenOddSubArrayEfficient(arr);
        System.out.println(res);
        res=maxEvenOddSubArray(arr);
        System.out.println(res);
    }

    static int maxEvenOddSubArray(int[] arr) {
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            int curr=1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] % 2 == 0 && arr[j-1] % 2 != 0 || arr[j] % 2 != 0 && arr[j-1] % 2 == 0) {
                    curr++;
                }else{
                    break;
                }
            }
            result =Math.max(result,curr);
        }
        return result;
    }

    static int maxEvenOddSubArrayEfficient(int[] arr) {
        int i=0;
        int result=1;
        while (i<arr.length) {
            int curr=1;
            while (i+1 < arr.length && ((arr[i] % 2 == 0 && arr[i+1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i+1] % 2 == 0))) {
                curr++;
                i++;
            }
            result =Math.max(result,curr);
            curr=1;
            i++;
        }
        return result;
    }
}
