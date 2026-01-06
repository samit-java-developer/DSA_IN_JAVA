package com.samit.string;

import java.util.Arrays;

public class LeftMostNonRepeatCharacter {

    public static void main(String[] args) {
        String input="geeksforforgeeks";
        int x=leftmostNonRepeatingNaive(input);
        System.out.println(x);
        x=leftmostNonRepeatingEfficient(input);
        System.out.println(x);
        x=oneTraversalEfficient(input);
        System.out.println(x);
    }

    static int leftmostNonRepeatingNaive(String input){
        for (int i=0;i<input.length();i++){
            boolean flag=false;
            for (int j = 0; j <input.length(); j++) {
                if (i!=j && input.charAt(i)==input.charAt(j)){
                    flag=true;
                    break;
                }
            }
            if (!flag){
                return i;
            }
        }
        return -1;
    }

    static int leftmostNonRepeatingEfficient(String input){
        int[] count=new int[256];
        Arrays.fill(count,0);
        for (int i=0;i<input.length();i++){
            count[input.charAt(i)]++;
        }
        for (int i=0;i<input.length();i++){
            if (count[input.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }

    static int oneTraversalEfficient(String input){
        int[] count=new int[256];
        Arrays.fill(count,-1);
        int res=Integer.MAX_VALUE;
        for (int i=0;i<input.length();i++){
            if (count[input.charAt(i)]==-1){
                count[input.charAt(i)]=i;
            }else{
                count[input.charAt(i)]=-2;
            }
        }
        for (int i=0;i<256;i++){
            if (count[i]>=0){
                res=Math.min(res,count[i]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
