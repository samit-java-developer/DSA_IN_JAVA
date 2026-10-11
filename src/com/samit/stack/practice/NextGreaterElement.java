package com.samit.stack.practice;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr={10,15,20,25};
        List<Integer> res=new ArrayList<>();
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int n=arr.length;
        stack.push(arr[n-1]);
        res.add(-1);
        for (int i=n-2;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res.add(-1);
            }else{
                res.add(stack.peek());
            }
            stack.push(arr[i]);
        }
    }
}
