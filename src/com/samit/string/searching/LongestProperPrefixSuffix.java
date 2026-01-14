package com.samit.string.searching;

import java.util.Arrays;

public class LongestProperPrefixSuffix {

    static int longestProperPrefixSuffix(String input,int n){
        for (int len=n-1;len>0;len--){
            boolean flag=true;
            for (int i=0;i<len;i++){
                if (input.charAt(i)!=input.charAt(n-len+i)){
                    flag=false;
                }
            }
            if (flag){
                return len;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String input="abacabad";
        int n=input.length();
        int[] lps=new int[n];
        for (int i=0;i<input.length();i++){
            lps[i]=longestProperPrefixSuffix(input,i+1);
        }
        System.out.println(Arrays.toString(lps));
    }
}
