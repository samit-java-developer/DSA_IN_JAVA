package com.samit.string;

import java.util.Arrays;

public class Anagram {
    private static final Integer CHAR_SIZE=256;
    public static void main(String[] args) {

        String s1="aabcah";
        String s2="acaba";

        boolean res=naive(s1,s2);
        System.out.println(res);

        res=efficient(s1,s2);
        System.out.println(res);
    }

    static boolean naive(String s1,String s2){
        if (s1.length()!=s2.length()){
            return false;
        }
        char[] ch1=s1.toCharArray();
        Arrays.sort(ch1);
        s1=new String(ch1);

        char[] ch2=s2.toCharArray();
        Arrays.sort(ch2);
        s2=new String(ch2);

        return s1.equals(s2);
    }

    static boolean efficient(String s1,String s2){
        if (s1.length()!=s2.length()){
            return false;
        }
        int[] count=new int[CHAR_SIZE];
        Arrays.fill(count,0);
        for (int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
