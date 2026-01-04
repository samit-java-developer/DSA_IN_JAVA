package com.samit.string;

public class CheckSubSequenceOrNot {

    public static void main(String[] args) {
        String s1="ABCDE";
        String s2="AED";
        boolean res=check(s1,s2);
        System.out.println(res);
        res=iterative(s1,s2);
        System.out.println(res);
        res=recursive(s1,s2,s1.length(),s2.length());
        System.out.println(res);
    }

    static boolean check(String s1, String s2){
        int i=0;
        int j=0;
        int m=s1.length();
        int n=s2.length();
        while (i<m && j<n){
            while (i<m && s1.charAt(i)!=s2.charAt(j)){
                i++;
            }
            if (i<m && s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
        }
        if (j==n){
            return true;
        }else {
            return false;
        }
    }

    static boolean iterative(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        if (n>m) return false;
        int j=0;
        for (int i=0;i<m && j<n;i++){
            if (s1.charAt(i)==s2.charAt(j)){
                j++;
            }
        }
        return j==n;
    }

    static boolean recursive(String s1,String s2,int m,int n){
        if (n==0){
            return true;
        }
        if (m==0){
            return false;
        }
        if (s1.charAt(m-1)==s2.charAt(n-1)){
            return recursive(s1,s2,m-1,n-1);
        }else{
            return recursive(s1,s2,m-1,n);
        }
    }
}
