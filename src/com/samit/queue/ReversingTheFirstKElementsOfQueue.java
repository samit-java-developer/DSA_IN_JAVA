package com.samit.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingTheFirstKElementsOfQueue {

    static void reverseQueueFirstKElements(int k, Queue<Integer> queue){
        if (queue.isEmpty() || queue.size()<k){
            return;
        }
        Stack<Integer> stack=new Stack<>();
        if (k<=0) return;
        int n=queue.size();
        for (int i=1;i<=k;i++){
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        for (int i=1;i<=n-k;i++){
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        queue.offer(80);
        queue.offer(90);
        queue.offer(100);
        for (int k:queue){
            System.out.print(k+" ");
        }
        System.out.println("------------------");
        reverseQueueFirstKElements(3,queue);
        for (int k:queue){
            System.out.print(k+" ");
        }
    }
}
