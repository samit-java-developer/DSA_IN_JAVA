package com.samit.stack;

class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

class Stack {
    Node head;
    int size;

    void push(int x) {
        Node temp = new Node(x);
        if (head == null) {
            head = temp;
            size++;
            return;
        }
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() {
        if (head == null) {
            System.out.println("Under flow, Please add first..");
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        size--;
        return temp.data;
    }

    int peek() {
        if (head == null) {
            System.out.println("Under flow, Please add first..");
        }
        return head.data;
    }

}

public class TestStackViaLinked {

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.size);
        System.out.println(stack.peek());
    }
}
