package com.samit.string;

import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String input="Deepak is my friend";
        String res=reverseWorsNaive(input);
        System.out.println(res);
        res=reverseWordEfficient(input);
        System.out.println(res);
    }

    static String reverseWorsNaive(String input){
        //via stack
        Stack<String> stackDs=new Stack<>();
        int start=0;
        for (int i=0;i<input.length();i++){
             if (input.charAt(i)==' '){
                 stackDs.push(input.substring(start,i));
                 start=i+1;
             }
        }
        stackDs.push(input.substring(start));
        StringBuilder result=new StringBuilder();
        while (!(stackDs.size()==1)){
            result.append(stackDs.pop()).append(" ");
        }
        result.append(stackDs.pop());
        return result.toString();
    }

    static String reverseWordEfficient(String input){
        char[] charArr=input.toCharArray();
        int start=0;
        int n=charArr.length;
        for (int i=0;i<n;i++){
            if (charArr[i]==' '){
                reverse(charArr,start,i-1);
                start=i+1;
            }
        }
        reverse(charArr,start,n-1);
        reverse(charArr,0,n-1);
        return new String(charArr);
    }

    static void reverse(char[] input,int low,int high){
        while (low<high){
            char ch=input[low];
            input[low]=input[high];
            input[high]=ch;
            low++;
            high--;
        }
    }
}
