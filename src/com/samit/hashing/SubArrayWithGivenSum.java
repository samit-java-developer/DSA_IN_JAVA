package com.samit.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr={9,1,2,8,4,6};
        boolean ans=check(arr,76);
        System.out.println(ans);
    }

    static boolean check(int[] arr,int sum){
        Set<Integer> set=new HashSet<>();
        int pre_sum=0;
        for (int i = 0; i < arr.length; i++) {
            pre_sum+=arr[i];
            if (pre_sum==sum) return true;
            if (set.contains(pre_sum-sum)) return true;
            else set.add(pre_sum);
        }
        return false;
    }
    
}
