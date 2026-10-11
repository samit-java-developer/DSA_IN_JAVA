package com.samit.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPrefix {

    static int getPrecedence(char ch){
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String infixToPrefix(String exp){
        StringBuilder result = new StringBuilder();
        Deque<Character> stack=new ArrayDeque<>();
        for (int i=exp.length()-1;i>=0;i--){
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)){
                result.append(c);
            } else if (c==')') {
                stack.push(c);
            } else if (c=='(') {
                while (!stack.isEmpty() && stack.peek()!=')'){
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }else{
                while (!stack.isEmpty() && getPrecedence(c)<=getPrecedence(stack.peek())){
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if (stack.peek() == ')')
                return "Invalid Expression";
            result.append(stack.peek());
            stack.pop();
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPrefix(exp));
    }
}
