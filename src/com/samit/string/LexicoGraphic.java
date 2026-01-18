package com.samit.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicoGraphic {

    static final Integer CHAR=256;

    public static void main(String[] args) {
        // input should be distinct.....
        String input="abc";
        String orderof="cab";
        List<String> results=permutations(input.toCharArray(),0);
        System.out.println(results);
        int x=results.indexOf(orderof);
        System.out.println(x+1);
        x=rankOfGivenString(orderof);
        System.out.println(x+1);
    }

    static List<String> permutations(char[] input,int i){
        List<String> res=new ArrayList<>();
        if (i==input.length-1){
            res.add(new String(input));
            return res;
        }
        for (int j=i;j<input.length;j++){
            swap(input,i,j);
            res.addAll(permutations(input,i+1));
            // back track
            swap(input,i,j);
        }
        return res;
    }

    static void swap(char[] input,int i,int j){
        char ch=input[i];
        input[i]=input[j];
        input[j]=ch;
    }

    // solving via efficient way....
    static int rankOfGivenString(String input){
        int[] count=new int[CHAR];
        Arrays.fill(count,0);
        int n=input.length();
        // because last character of string result is always one
        int res=1;
        int mul=fact(n);
        for (int i=0;i<n;i++){
            count[input.charAt(i)]++;
        }
        for (int i=1;i<CHAR;i++){
            count[i]=count[i]+count[i-1];
        }
        for (int i=0;i<n-1;i++){
            mul=mul/(n-i);
            res=res+count[input.charAt(i)-1]*mul;
            for (int j=input.charAt(i);j<CHAR;j++){
                count[j]--;
            }
        }
        return res;
    }

    static int fact(int n){
        if (n==0 || n==1){
            return 1;
        }
        return n*fact(n-1);
    }


}
