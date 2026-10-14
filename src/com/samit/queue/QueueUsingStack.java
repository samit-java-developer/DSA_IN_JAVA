package com.samit.queue;

import java.util.Stack;

class QueueStack{
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    public void enqueue(int x){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}

public class QueueUsingStack {

    public static void main(String[] args) {

    }
}
