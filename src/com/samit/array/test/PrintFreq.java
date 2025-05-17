package com.samit.array.test;

public class PrintFreq {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,3,4,4,4,5};
        printFreq(arr);
    }
    static void printFreq(int[] arr) {
        int n = arr.length;
        int frequency = 1;
        int i=0;
        while (i < n-1) {
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                frequency = frequency + 1;
                i++;
            }
            System.out.println(arr[i] + " -> " + frequency);
            i++;
            frequency = 1;
        }
        if(n==1 || arr[n-1]!=arr[n-2]){
            System.out.println(arr[n-1] + " -> 1");
        }
    }
}
