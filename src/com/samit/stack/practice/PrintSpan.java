package com.samit.stack.practice;

import java.util.ArrayDeque;

public class PrintSpan {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int[] arr={13,15,12,14,16,8,6,4,10,30};
        stack.push(0);
        System.out.print(1+" ");
        int span=1;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            span=stack.isEmpty()?i+1:i-stack.peek();
            System.out.print(span+" ");
            stack.push(i);
        }
    }
}
