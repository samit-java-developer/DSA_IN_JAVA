package com.samit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubSequence {

    public static void main(String[] args) {
        int[] arr={1,3,4,3,3,2,9,10};
        int res=longestSubSeq(arr);
        System.out.println(res);
    }

    static int longestSubSeq(int[] arr){
        Set<Integer> sets=Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int res=0;
        for (int x: sets){
            int curr=1;
            if (!sets.contains(x-1)){
                int temp=x;
                while(sets.contains(temp+1)){
                    temp++;
                    curr++;
                }
                res=Math.max(res,curr);
            }
        }
        return res;
    }
}
