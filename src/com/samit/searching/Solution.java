package com.samit.searching;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int n=arr.length;
        int[] prefixSum=new int[n];
        prefixSum[0]=arr[0];
        for (int i=1;i<n;i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if (i==0){
                    if (prefixSum[j]==target){
                        list.add(1);
                        list.add(j+1);
                        return list;
                    }
                }else{
                    if ((prefixSum[j]-prefixSum[i-1])==target){
                        list.add(i+1);
                        list.add(j+1);
                        return list;
                    }
                }
            }
        }
        list.add(-1);
        return list;
    }

    static List<Integer> indexOfSubArraySum(int[] arr,int target){
        int start=0;
        int sum=0;
        List<Integer> res=new ArrayList<>();
        for (int end=0;end<arr.length;end++){
            sum+=arr[end];
            while (sum>target && start<=end){
                sum-=arr[start++];
            }
            if (sum==target){
                res.add(start+1);
                res.add(end+1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 7, 5};
        int target=12;
        List<Integer> list=Solution.indexOfSubArraySum(arr,target);
        System.out.println(list);
    }
}
