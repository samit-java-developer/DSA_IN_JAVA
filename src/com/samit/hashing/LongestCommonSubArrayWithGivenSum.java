package com.samit.hashing;

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
        int[] temp=new int[n];
        for (int i=0;i<n;i++){
            temp[i]=arr1[i]-arr2[i];
        }
        int pre_sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int res=0;
        for (int i=0;i<n;i++){
            pre_sum+=temp[i];
            if (map.containsKey(pre_sum)){
                res=Math.max(res,i-map.get(pre_sum));
            }else{
                map.put(pre_sum,i);
            }
        }
        return res;
    }
}
