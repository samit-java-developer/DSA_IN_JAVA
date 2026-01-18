package com.samit.string;

import java.util.Arrays;

public class AnagramSearch {

    public static void main(String[] args) {
        String text="geeksforgeeks";
        String pat="grof";
        System.out.println(naive(text,pat));
        System.out.println(efficient(text,pat));
    }
    static boolean naive(String text,String pat){
        int n=text.length();
        int m=pat.length();
        for (int i=0;i<=n-m;i++){
            if (areAnagram(text,pat,i)){
                return true;
            }
        }
        return false;
    }
    static boolean areAnagram(String text,String pat,int i){
        int[] count=new int[256];
        Arrays.fill(count,0);
        for (int j=0;j<pat.length();j++){
            count[text.charAt(i+j)]++;
            count[pat.charAt(j)]--;
        }
        for (int k=0;k<256;k++){
            if (count[k]!=0){
                return false;
            }
        }
        return true;
    }
    // via sliding window
    static boolean efficient(String text,String pat){
        int[] countT=new int[256];
        int[] countP=new int[256];
        for (int i=0;i<pat.length();i++){
            countT[text.charAt(i)]++;
            countP[pat.charAt(i)]++;
        }
        if (isSame(countT,countP)){
            return true;
        }
        for (int i=pat.length();i<text.length();i++){
            countT[text.charAt(i)]++;
            countT[text.charAt(i-pat.length())]--;
            if (isSame(countT,countP)){
                return true;
            }
        }
        return false;
    }
    static boolean isSame(int[] arr1,int[] arr2){
        for (int i=0;i<256;i++){
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
