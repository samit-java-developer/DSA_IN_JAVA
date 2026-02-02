package com.samit.stack;

import java.util.ArrayDeque;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        int[] arr={20,30,10,5,15};
        printPreviousGreater(arr);
    }
    static void printPreviousGreater(int[] arr){
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(arr[0]);
        System.out.print(-1+" ");
        for (int i=1;i<arr.length;i++){
            while (!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                System.out.print(-1+" ");
            }else {
                System.out.print(stack.peek()+" ");
            }
            stack.push(arr[i]);
        }
    }
}
