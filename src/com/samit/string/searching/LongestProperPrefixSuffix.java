package com.samit.string.searching;

import java.util.Arrays;

public class LongestProperPrefixSuffix {
    // O(n^3)
    static int longestProperPrefixSuffix(String input,int n){
        for (int len=n-1;len>0;len--){
            boolean flag=true;
            for (int i=0;i<len;i++){
                if (input.charAt(i)!=input.charAt(n-len+i)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                return len;
            }
        }
        return 0;
    }

    //O(n) efficient solution of filling lps
    static void fillLps(String input,int[] lps){
        int n=input.length();
        int len=0;
        lps[0]=0;
        int i=1;
        while (i<n){
            if (input.charAt(len)==input.charAt(i)){
                lps[i]=len+1;
                len++;
                i++;
            }else{
                if (len==0){
                    lps[i]=0;
                    i++;
                }else{
                    len=lps[len-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        String input="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int n=input.length();
        int[] lps=new int[n];
        long start=System.currentTimeMillis();
        for (int i=0;i<input.length();i++){
            lps[i]=longestProperPrefixSuffix(input,i+1);
        }
        long end=System.currentTimeMillis();
        System.out.println(Arrays.toString(lps));
        System.out.println(end-start);
        start=System.currentTimeMillis();
        fillLps(input,lps);
        end=System.currentTimeMillis();
        System.out.println(Arrays.toString(lps));
        System.out.println(end-start);
    }
}
