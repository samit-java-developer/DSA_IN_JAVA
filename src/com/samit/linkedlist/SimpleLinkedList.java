package com.samit.linkedlist;

public class SimpleLinkedList {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Node head=new Node(10);
        Node temp1=new Node(20);
        Node temp2=new Node(30);
        head.next=temp1;
        temp1.next=temp2;
        System.out.println(head.next.next.data);
        System.out.println("Insert At Begin");
        head=insertAtBegin(5,head);
        printViaRecursion(head);
    }

    public static Node insertAtBegin(int data,Node head){
        Node insertNode=new Node(data);
        if (head==null){
            head=insertNode;
            return head;
        }
        insertNode.next=head;
        head=insertNode;
        return head;
    }

    public static void printViaRecursion(Node head){
        if (head==null){
            return;
        }
        System.out.print(head.data + " ");
        printViaRecursion(head.next);
    }
}
