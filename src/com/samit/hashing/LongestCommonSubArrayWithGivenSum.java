package com.samit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr1={0,1,0,0,0,0};
        int[] arr2={1,0,1,0,0,1};
        int res=longestCommonSubArrNaive(arr1,arr2);
        System.out.println(res);

        res=longestCommonSubArrEfficient(arr1,arr2);
        System.out.println(res);
        int[] arr={0,1,2,1,0,2,1,0};
        sortBooleanArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sortBooleanArray(int[] arr){
        int n=arr.length;
        int i=0;
        int j=0;
        int k=n-1;
        while (j<=k){
            if (arr[j]==0){
                swap(arr,i,j);
                i++;
                j++;
            }else if (arr[j]==1){
                j++;
            }else{
                swap(arr,j,k);
                k--;
            }
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static int longestCommonSubArrNaive(int[] arr1,int[] arr2){
        int n=arr1.length;
        int res=0;
        for (int i=0;i<n;i++){
            int sum1=0,sum2=0;
            for (int j = i; j < n; j++) {
                sum1+=arr1[j];
                sum2+=arr2[j];
                if (sum1==sum2){
                    res=Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }

    static int longestCommonSubArrEfficient(int[] arr1,int[] arr2){
        int n=arr1.length;
//        int[] temp=new int[n];
//        for (int i=0;i<n;i++){
//            temp[i]=arr1[i]-arr2[i];
//        }
        int pre_sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int res=0;
        for (int i=0;i<n;i++){
            pre_sum+=arr1[i]-arr2[i];
            if (map.containsKey(pre_sum)){
                res=Math.max(res,i-map.get(pre_sum));
            }else{
                map.put(pre_sum,i);
            }
        }
        return res;
    }
}
