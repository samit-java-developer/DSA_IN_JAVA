package com.samit.stack;

import java.util.ArrayDeque;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr={20,30,10,5,15};
        printNextGreater(arr);
    }
    static void printNextGreater(int[] arr){
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        ArrayDeque<Integer> res=new ArrayDeque<>();
        int n=arr.length;
        stack.push(arr[n-1]);
        res.push(-1);
        for (int i=n-2;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res.push(-1);
            }else {
                res.push(stack.peek());
            }
            stack.push(arr[i]);
        }
        while (!res.isEmpty()){
            System.out.print(res.peek()+" ");
            res.pop();
        }
    }
}
