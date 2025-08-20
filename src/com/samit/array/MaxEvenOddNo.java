package com.samit.array;

public class MaxEvenOddNo {

    public static void main(String[] args) {
        //int[] arr={74,80,8,13,37,49,20,6};
        int[] arr={10,12,14,7,8};
        int res=maxEvenOdd(arr);
        System.out.println(res);
    }
    public static int maxEvenOdd(int arr[]) {
        int result=1;
        int n=arr.length;
        int count=1;
        int i=0;
        while (i<n) {
            while ((i + 1) < n && ((arr[i] % 2 == 0 && arr[i + 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i + 1] % 2 == 0))) {
                count++;
                i++;
                result = Math.max(count, result);
            }
            i++;
            count = 1;
        }
        return result;
    }
}
