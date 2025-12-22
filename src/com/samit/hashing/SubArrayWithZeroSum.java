package com.samit.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int[] arr={9,1,2,8,4,6};
        boolean ans=check(arr);
        System.out.println(ans);
    }

    static boolean check(int[] arr){
        Set<Integer> set=new HashSet<>();
        int pre_sum=0;
        for (int i = 0; i < arr.length; i++) {
            pre_sum+=arr[i];
            if (pre_sum==0) return true;
            if (set.contains(pre_sum)) return true;
            else set.add(pre_sum);
        }
        return false;
    }

}
