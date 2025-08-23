package com.samit.bitmagic;

public class TwoOddOccurrence {
    public static void main(String[] args) {
        int[] arr={1,2,2,3};
        printTwoOccurrenceNaive(arr);
        printTwoOccurrenceEfficient(arr);
    }

    static void printTwoOccurrenceNaive(int[] arr){
        int n=arr.length;
        for (int k : arr) {
            int count = 0;
            for (int i : arr) {
                if (k == i) {
                    count++;
                }
            }
            if (count%2!=0) System.out.println(k + " count is " + count);
        }
    }
    static void printTwoOccurrenceEfficient(int[] arr){
        int x=arr[0];
        int n=arr.length;
        int res1=0,res2=0;
        for (int i=1;i<n;i++){
            x=x^arr[i];
        }
        int k=(x & -(x-1));
        for (int j : arr) {
            if ((j & k) != 0) {
                res1 = res1 ^ j;
            } else {
                res2 = res2 ^ j;
            }
        }
        System.out.print(res1+" "+res2);
    }
}
