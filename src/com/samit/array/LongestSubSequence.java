package com.samit.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestSubSequence {

    public static void main(String[] args) {
        int[] arr={2,9,4,3,10};
        int xx=longestSubSequence(arr);
        System.out.println(xx);
        xx=efficient(arr);
        System.out.println(xx);
    }

    static int longestSubSequence(int[] arr){
        Arrays.sort(arr);
        int res=1,curr=1;
        int n=arr.length;
        for (int i=1;i<n;i++){
            if (arr[i]==arr[i-1]+1){
                curr++;
            }else if (arr[i]!=arr[i-1]){
                res=Math.max(res,curr);
                curr=1;
            }
        }
        return res;
    }

    static int efficient(int[] arr){
        Set<Integer> sets=new HashSet<>(IntStream.of(arr).boxed().toList());
        int res=0;
        for (int x: arr){
            if (!sets.contains(x-1)){
                int temp=x;
                int count=1;
                while (sets.contains(temp+1)) {
                    temp++;
                    count++;
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

}
