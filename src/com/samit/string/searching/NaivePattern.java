package com.samit.string.searching;

public class NaivePattern {

    public static void main(String[] args) {
        String text="ABCABCD";
        String pat="ABCD";
        patSearching(text,pat);
        System.out.println();
        patternDistinct(text,pat);
    }
    static void patSearching(String text,String pat){
        int n=text.length();
        int m=pat.length();
        for (int i=0;i<=n-m;i++){
            int j;
            for (j=0;j<m;j++){
                if (text.charAt(i+j)!=pat.charAt(j)){
                    break;
                }
            }
            if (j==m){
                System.out.print(i+" ");
            }
        }
    }

    static void patternDistinct(String text,String pat){
        int n=text.length();
        int m=pat.length();
        for (int i=0;i<=n-m;){
            int j;
            for (j=0;j<m;j++){
                if (text.charAt(i+j)!=pat.charAt(j)){
                    break;
                }
            }
            if (j==m){
                System.out.print(i+" ");
            }
            if (j==0){
                i++;
            }else {
                i=i+j;
            }
        }
    }
}
