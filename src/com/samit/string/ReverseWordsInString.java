package com.samit.string;

import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String input="Deepak is my friend";
        String res=reverseWorsNaive(input);
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
}
