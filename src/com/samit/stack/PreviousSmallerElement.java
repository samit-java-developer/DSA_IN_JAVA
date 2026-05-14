package com.samit.stack;

import java.util.ArrayDeque;

public class PreviousSmallerElement {

    public static void main(String[] args) {
        int[] arr={6,2,5,4,1,5,6};
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        System.out.print(-1+" ");
        int n=arr.length;
        for (int i=1;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(stack.peek()+" ");
            }
            stack.push(i);
        }

        System.out.println("---------------------");
        //next smaller
        stack.clear();
        System.out.print(n+" ");
        stack.push(n-1);
        for (int i=n-2;i>=0;i--){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                System.out.print(n+" ");
            }else{
                System.out.print(stack.peek()+" ");
            }
            stack.push(i);
        }
    }
}
