package com.samit.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubArraySum {

    public static void main(String[] args) {
        int[] arr={3,1,0,1,8,2,3,6};
        int sum=5;
        int res=findLongestSubArraySum(arr,sum);
        System.out.println(res);
        System.out.println("------------");
        res=naive(arr,sum);
        System.out.println(res);

        arr=new int[]{5,8,-4,-4,9,-2,2};
        sum=0;
        res=findLongestSubArraySum(arr,sum);
        System.out.println(res);
        System.out.println("------------");
        res=naive(arr,sum);
        System.out.println(res);

        arr=new int[]{8,3,7};
        sum=15;
        res=findLongestSubArraySum(arr,sum);
        System.out.println(res);
        System.out.println("------------");
        res=naive(arr,sum);
        System.out.println(res);

    }

    static int findLongestSubArraySum(int[] arr,int sum){
        int n=arr.length;
        Map<Integer,Integer> map=new LinkedHashMap<>();
        int pre_sum=0;
        int res=0;
        for(int i=0;i<n;i++){
            pre_sum+=arr[i];
            if (pre_sum==sum){
                res=Math.max(res,i+1);
            }
            if (map.containsKey(pre_sum-sum)){
                if (map.get(pre_sum-sum)==0){
                    res=Math.max((i-map.get(pre_sum-sum)),res);
                }else{
                    res=Math.max((i-map.get(pre_sum-sum))+1,res);
                }
            }else{
                map.put(pre_sum,i);
            }
        }
        return res;
    }

    static int naive(int[] arr,int sum){
        int n=arr.length;
        int res=0;
        for (int i = 0; i < n; i++) {
            int curr_sum=0;
            for (int j=i;j<n;j++){
                curr_sum+=arr[j];
                if (curr_sum==sum){
                    res=Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
}
