package com.samit.queue;

import java.util.LinkedList;
import java.util.Queue;

class StackQueue{
    Queue<Integer> q1=new LinkedList<Integer>();
    Queue<Integer> q2=new LinkedList<Integer>();
    int curr_size=0;
    // via making push operation costly....
    void push(int x){
        if (q1.isEmpty()){
            q1.offer(x);
        }else{
            q2.offer(x);
            while (!q1.isEmpty()){
                q2.offer(q1.poll());
            }
            Queue<Integer> tempQ=q1;
            q1=q2;
            q2=tempQ;
        }
        curr_size++;
    }

    void pop(){
        if (q1.isEmpty())return;
        q1.poll();
        curr_size--;
    }

    int top(){
        if (!q1.isEmpty()){
            return q1.peek();
        }
        return -1;
    }
}

class StackQueueUsingPop{
    Queue<Integer> q1=new LinkedList<Integer>();
    Queue<Integer> q2=new LinkedList<Integer>();
    int curr_size=0;
    // via making push operation costly....
    void push(int x){
        q1.offer(x);
        this.curr_size++;
    }

    void pop() throws Exception {
        if (this.curr_size==0) throw new Exception("Stack is Empty...");
        while (q1.size()!=1){
            q2.offer(q1.poll());
        }
        int xx=q1.poll();
        this.curr_size--;
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }

    int top(){
        if (this.curr_size==0) return -1;
        while (q1.size()!=1){
            q2.offer(q1.poll());
        }
        int xx=q1.poll();
        q2.offer(xx);
        this.curr_size--;
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return xx;
    }
}

public class StackUsingQueue {
    public static void main(String[] args) throws Exception {
        StackQueue stackQueue=new StackQueue();
        stackQueue.push(10);
        stackQueue.push(20);
        stackQueue.push(30);
        System.out.println("Top element :: "+stackQueue.top());
        stackQueue.push(40);
        System.out.println("Top element :: "+stackQueue.top());
        stackQueue.pop();
        System.out.println("Top element :: "+stackQueue.top());

        System.out.println("------------");
        StackQueueUsingPop stackQueueUsingPop=new StackQueueUsingPop();
        stackQueueUsingPop.push(10);
        stackQueueUsingPop.push(20);
        stackQueueUsingPop.push(30);
        System.out.println("Top element :: "+stackQueueUsingPop.top());
        stackQueueUsingPop.push(40);
        System.out.println("Top element :: "+stackQueueUsingPop.top());
        stackQueueUsingPop.pop();
        System.out.println("Top element :: "+stackQueueUsingPop.top());

    }
}
