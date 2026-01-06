package com.samit.string;

import java.util.Arrays;

public class LeftMostRepeatCharacter {

    static final int CHAR=256;

    public static void main(String[] args) {
        String input="abccbda";
        int res=leftMostNaive(input);
        System.out.println(res);
        res=leftMostEfficient(input);
        System.out.println(res);
        res=moreEfficient(input);
        System.out.println(res);
        res=bestEfficient(input);
        System.out.println(res);
    }

    static int leftMostNaive(String input){
        for (int i=0;i<input.length();i++){
            for (int j=i+1;j<input.length();j++){
                if (input.charAt(i)==input.charAt(j)){
                    return i;
                }
            }
        }
        return -1;
    }

    static int leftMostEfficient(String input){
        int[] count=new int[CHAR];
        Arrays.fill(count,0);
        int n=input.length();
        for (int i=0;i<input.length();i++){
            count[input.charAt(i)]++;
        }
        for (int i=0;i<n;i++){
            if (count[input.charAt(i)]>1){
                return i;
            }
        }
        return -1;
    }

    static int moreEfficient(String input){
        int[] count=new int[CHAR];
        Arrays.fill(count,-1);
        int res=Integer.MAX_VALUE;
        for (int i=0;i<input.length();i++){
            int fi=count[input.charAt(i)];
            if (fi==-1){
                count[input.charAt(i)]=i;
            }else{
                res=Math.min(res,fi);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    static int bestEfficient(String input){
        int n=input.length();
        boolean[] visited=new boolean[CHAR];
        Arrays.fill(visited,false);
        int res=-1;
        for (int i=n-1;i>=0;i--){
            if (visited[input.charAt(i)]){
                res=i;
            }else{
                visited[input.charAt(i)]=true;
            }
        }
        return res;
    }
}
