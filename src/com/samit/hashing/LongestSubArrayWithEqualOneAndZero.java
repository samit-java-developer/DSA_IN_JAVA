package com.samit.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqualOneAndZero {

    static int longest(int[] arr){
        int n=arr.length;
        int res=0;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int countOne=0;
                for (int k=0;k<=j && (i+k)<n;k++){
                    if (arr[i+k]==1){
                        countOne++;
                    }
                }
                // checking now that subarray has equal one and zero.
                if ((j-i+1)/2==countOne){
                  res=Math.max(res,(j-i)+1);
                }
            }
        }
        return res;
    }

    static int longestNaiveGeeks(int[] arr){
        int n=arr.length;
        int res=0;
        for (int i=0;i<n;i++){
            int c0=0;
            int c1=0;
            for (int j = i; j < n; j++) {
                if (arr[j]==0){
                    c0++;
                }
                if (arr[j]==1){
                   c1++;
                }
                if (c0==c1){
                    res=Math.max(res,c0+c1);
                }
            }
        }
        return res;
    }

    static int longestMediumEfficient(int[] arr){
        int n=arr.length;
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        map.put(-1,0);
        for (int i=0;i<n;i++){
            if (arr[i]==1){
                count++;
            }
            map.put(i,count);
        }
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if (i!=j){
                    // count 1 between i and j is
                    int countOne=map.get(j)-map.get(i-1);
                    if ((j-i+1)/2==countOne){
                        res=Math.max(res,j-i+1);
                    }
                }
            }
        }
        return res;
    }

    static int longestSubArrayWithSameZeroAndOne(int[] arr){
        int n=arr.length;
        int prefix_sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        map.put(0,-1);
        for (int i=0;i<n;i++){
            prefix_sum+=arr[i]==0?-1:1;
            if (map.containsKey(prefix_sum)){
                res=Math.max(res,(i-map.get(prefix_sum)));
            }else{
                map.put(prefix_sum,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,1,1,0};
        int res=longest(arr);
        System.out.println(res);

        res=longestMediumEfficient(arr);
        System.out.println(res);

        res=longestSubArrayWithSameZeroAndOne(arr);
        System.out.println(res);

        res=longestNaiveGeeks(arr);
        System.out.println(res);
    }
}
