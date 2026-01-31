package com.samit.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckedForBalancedParenthesis {

    static boolean check(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else {
                if (stack.isEmpty()){
                    return false;
                }else{
                    if (input.charAt(i) == '}') {
                        if (stack.peek()!='{'){
                            return false;
                        }else{
                            stack.pop();
                        }
                    }
                    if (input.charAt(i) == ']') {
                        if(stack.peek()!='['){
                            return false;
                        }else{
                            stack.pop();
                        }
                    }
                    if (input.charAt(i) == ')') {
                        if(stack.peek()!='('){
                            return false;
                        }else{
                            stack.pop();
                        }
                    }
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input="{}({})";
        System.out.println(check(input));
    }
}
