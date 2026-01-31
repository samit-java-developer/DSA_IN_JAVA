package com.samit.stack;

public class TwoStacksInOneArr {
    int[] arr;
    int top1;
    int top2;
    int cap;
    TwoStacksInOneArr(int n){
        this.cap=n;
        arr=new int[n];
        this.top1=-1;
        this.top2=n;
    }
    boolean push1(int x){
        if ((top1+1)!=top2){
            arr[++top1]=x;
            return true;
        }else{
            System.out.println("Stack is full...");
            return false;
        }
    }

    boolean push2(int x){
        if ((top2-1)!=top1){
            arr[--top2]=x;
            return true;
        }else{
            System.out.println("Stack is full...");
            return false;
        }
    }

    int pop1(int x){
        if (top1==-1){
            System.out.println("Stack is empty...");
            return -1;
        }else{
            int res=arr[top1];
            top1--;
            return res;
        }
    }

    int pop2(int x){
        if (top2==cap){
            System.out.println("Stack is empty...");
            return -1;
        }else{
            int res=arr[top2];
            top2++;
            return res;
        }
    }

    int size1(){
        return top1+1;
    }
    int size2(){
        return cap-top2;
    }


    public static void main(String[] args) {
        TwoStacksInOneArr twoStack=new TwoStacksInOneArr(10);
        twoStack.push1(1);
        twoStack.push1(2);
        twoStack.push1(3);
        twoStack.push1(4);
        twoStack.push1(5);
        twoStack.push2(10);
        twoStack.push2(9);
        twoStack.push2(8);
        twoStack.push2(7);
        twoStack.push2(6);
        System.out.println("Stack1 size");
        System.out.println(twoStack.size1());
        System.out.println("Stack2 size");
        System.out.println(twoStack.size2());
        twoStack.push1(11);
        twoStack.push2(13);
        System.out.println("Stack1 size");
        System.out.println(twoStack.size1());
        System.out.println("Stack2 size");
        System.out.println(twoStack.size2());
    }
}
