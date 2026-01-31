package com.samit.stack;

class MyStack {
    int[] arr;
    int top;
    int cap;
    MyStack(int cap){
        this.arr=new int[cap];
        this.top=-1;
        this.cap=cap;
    }

    void push(int x){
        if ((top+1)==cap){
            System.out.println("Over Flow Please remove some item...");
        }
        this.arr[++this.top]=x;
    }
    int pop(){
        if (top==-1){
            System.out.println("Under Flow Please add some item...");
        }
        return arr[top--];
    }
    int peek(){
        if (top==-1){
            System.out.println("Under Flow Please add some item...");
            return -100;
        }
        return arr[top];
    }
    int size(){
        return top+1;
    }

    boolean isEmpty(){
        return top==-1;
    }
}

public class TestViaArrStack{
    public static void main(String[] args) {
        MyStack stack=new MyStack(5);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        stack.push(30);
        System.out.println(stack.size());
    }
}