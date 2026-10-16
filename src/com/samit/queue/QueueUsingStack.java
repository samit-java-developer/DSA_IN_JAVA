package com.samit.queue;

import java.util.Stack;

class QueueStack{
    static Stack<Integer> stack1=new Stack<>();
    static Stack<Integer> stack2=new Stack<>();

    public void enqueue(int x) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int dequeue(){
        return stack1.pop();
    }
}

public class QueueUsingStack {

    public static void main(String[] args) {
        QueueStack queue=new QueueStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        queue.enqueue(40);
        System.out.print(queue.dequeue()+" ");
    }
}
