package com.samit.stack;

class StackNew{
    int top;
    int cap;
    int[] arr;
    int[] auxSpace;
    int top2;
    StackNew(int cap){
        this.cap=cap;

        this.top=-1;
        this.top2=-1;
        this.arr=new int[this.cap];
        this.auxSpace=new int[this.cap];
    }
    void push(int x){
        if (top+1==this.cap){
            System.out.println("not able to push now...");
            return;
        }
        this.arr[++top]=x;
        if (top2==-1){
            this.auxSpace[++top2]=x;
        }else{
            if (this.auxSpace[top2]>=x){
                this.auxSpace[++top2]=x;
            }
        }
    }

    int pop(){
        if (top==-1){
            System.out.println("not able to pop now...");
            return 0;
        }
        if (this.arr[top]==this.auxSpace[top2]){
           top2--;
        }
        return this.arr[top--];
    }
    int getMin(){
        return this.auxSpace[this.top2];
    }
}

class Stack2{
    int top;
    int cap;
    int[] arr;
    int min;
    Stack2(int cap){
        this.cap=cap;
        this.top=-1;
        this.arr=new int[this.cap];
        this.min=0;
    }
    void push(int x){
        if (top+1==this.cap){
            System.out.println("not able to push now...");
            return;
        }
        if (this.top==-1){
            this.arr[++top]=x;
            this.min=x;
        }else if (x<=min){
            this.arr[++top]=x-min;
            min=x;
        }else{
            this.arr[++top]=x;
        }
    }

    int pop(){
        if (this.top==-1){
            System.out.println("not able to pop now...");
            return 0;
        }
        int res;
        int t=this.arr[top--];
        if (t<=0){
            res=min;
            min=min-t;
            return res;
        }else {
            return t;
        }
    }
    int getMin(){
        return this.min;
    }
}
public class GetMinimumInStack {
    public static void main(String[] args) {
        StackNew stackNew=new StackNew(20);
        stackNew.push(5);
        stackNew.push(10);
        stackNew.push(20);
        stackNew.push(2);
        System.out.println( stackNew.getMin());
        stackNew.push(6);
        stackNew.push(4);
        System.out.println( stackNew.getMin());
        stackNew.pop();
        stackNew.pop();
        stackNew.push(2);
        System.out.println( stackNew.getMin());
        stackNew.pop();
        stackNew.push(1);
        System.out.println( stackNew.getMin());

        System.out.println("--------------------------");

        Stack2 sta=new Stack2(20);
        sta.push(5);
        sta.push(10);
        sta.push(20);
        sta.push(2);
        System.out.println( sta.getMin());
        sta.push(6);
        sta.push(4);
        System.out.println( sta.getMin());
        sta.pop();
        sta.pop();
        sta.push(2);
        System.out.println( sta.getMin());
        sta.pop();
        sta.push(1);
        System.out.println( sta.getMin());
    }
}
