package com.samit.searching;

import java.util.Arrays;

public class FirstRepeat {

    public static void main(String[] args) {
      // Repeat element 1 to n-1 is present
        // Repeat element 0 to n-2 is present
        //All should be present from 0 to max(arr) therefore 0<=max(arr)<=n-2
        int[] arr={1,3,2,4,6,5,7,3};
        int x=findRepeatSuperNaive(arr);
        System.out.println(x);
        x=findRepeatNaive(arr);
        System.out.println(x);
        x=findRepeatEfficient(arr);
        System.out.println(x);
    }

    static int findRepeatSuperNaive(int[] arr){
        int n=arr.length;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    return arr[i];
                }
            }
        }
        return 0;
    }
    static int findRepeatNaive(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        for (int i=0;i<n-1;i++){
            if (arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return 0;
    }

     static int findRepeatEfficient(int[] arr){
        int slow=arr[0];
        int fast=arr[0];
        do{
            slow=arr[slow];
            fast=arr[arr[fast]];
        }
        while (slow!=fast);
        slow=arr[0];
        while (slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }
        return slow;
     }
}
