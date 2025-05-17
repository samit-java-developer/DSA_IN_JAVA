package com.samit.array.test;

import java.util.Arrays;

public class LeadersInArray {

    public static void main(String[] args) {
        int[] arr = { 7,10,4,10,6,5,2};
        leadersInArray(arr);
        System.out.println();
        leadersInArrayEfficient(arr);
    }
    static void leadersInArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]>=arr[i]){
                    flag = true;
                }
            }
            if (flag == false){
                System.out.print(arr[i]+" ");
            }
        }
    }

    static void leadersInArrayEfficient(int[] arr) {
       int curr_leader = arr[arr.length-1];
       System.out.print(curr_leader+" ");
       for (int i=arr.length-2; i>=0; i--) {
           if (arr[i]>curr_leader){
               curr_leader = arr[i];
               System.out.print(arr[i]+" ");
           }
       }
    }
}
