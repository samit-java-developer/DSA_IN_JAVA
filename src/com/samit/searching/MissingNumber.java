package com.samit.searching;

import java.util.Arrays;

public class MissingNumber {

    static class Solution {
        public int missingNumber(int[] arr) {
            int max=Integer.MIN_VALUE;
            int n=arr.length;
            for (int i=0;i<n;i++){
                max=Math.max(arr[i],max);
            }
            if (max<0){
                return 1;
            }
            boolean[] constArr=new boolean[max+1];
            for (int i=0;i<n;i++){
                if (arr[i]>0){
                    constArr[arr[i]]=true;
                }
            }
            for (int i=1;i<constArr.length;i++){
                if (!constArr[i]){
                    return i;
                }
            }
            return max+1;
        }
    }

    static int missingNoUsingSorting(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        int res=1;
        for (int i=0;i<n;i++){
            if (arr[i]==res){
                res++;
            }
            if (arr[i]>res){
                break;
            }
        }
        return res;
    }

    static int missingUsingCycleSort(int[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            while (arr[i]>=1 && arr[i]<=n && arr[i]!=arr[arr[i]-1]){
                int temp=arr[i];
                arr[i]=arr[arr[i]-1];
                arr[temp-1]=temp;
            }
        }
        for (int i=1;i<=n;i++){
            if (i!=arr[i-1]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr= Arrays.stream("2 -3 4 1 1 7".split(" ")).mapToInt(Integer::parseInt).toArray();

        int x=new MissingNumber.Solution().missingNumber(arr);
        System.out.println(x);
        x=MissingNumber.missingNoUsingSorting(arr);
        System.out.println(x);
        x=MissingNumber.missingUsingCycleSort(arr);
        System.out.print(x);
    }
}
