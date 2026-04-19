package com.samit.string;

public class ReverseWords {
    public static void main(String[] args) {
        String input="ie.l";
        String res=cleanString(input);
        System.out.println(res);
    }

    static String cleanString(String input){
        int i=0;
        int n=input.length();
        StringBuilder sb=new StringBuilder();
        while (i<n && input.charAt(i)=='.'){
            i++;
        }
        while (i<n) {
            if (input.charAt(i) != '.') {
                sb.append(input.charAt(i));
                i++;
                continue;
            }
            while (i<n && input.charAt(i)=='.'){
                i++;
            }
            if (i<=n-1){
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
