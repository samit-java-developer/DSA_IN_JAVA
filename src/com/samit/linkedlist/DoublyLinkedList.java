package com.samit.linkedlist;

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;
    DoublyNode(int data) {
        this.data = data;
        next=prev=null;
    }
}
public class DoublyLinkedList {
    DoublyNode head;

    void insertAtBegin(int data){
        DoublyNode node=new DoublyNode(data);
        if (head==null){
            head=node;
            return;
        }
        node.next=head;
        head.prev=node;
        head=node;
    }
    void insertAtEnd(int data){
        DoublyNode node=new DoublyNode(data);
        if (head==null){
            head=node;
            return;
        }
        DoublyNode temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
    }

    void reverseDoubly(){
        DoublyNode temp=null;
        DoublyNode curr=head;
        while (curr!=null){
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        if (head!=null) head=temp.prev;
    }

    void printDoublyLinkedList(){
        DoublyNode temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    void deleteAtBegin(){
        DoublyNode temp=head;
        if (temp==null || temp.next==null){
            head=null;
            return;
        }
        DoublyNode next=temp.next;
        temp.next=null;
        next.prev=null;
        head=next;
    }

    void deleteAtLast(){
        DoublyNode temp=head;
        if (temp==null || temp.next==null){
            head=null;
            return;
        }
        while (temp.next.next!=null){
            temp=temp.next;
        }
        temp.next.prev=null;
        temp.next=null;
    }
    public static void main(String[] args) {
        DoublyLinkedList list=new DoublyLinkedList();
        list.insertAtBegin(1);
        list.insertAtBegin(3);
        list.printDoublyLinkedList();
        list.insertAtEnd(4);
        list.printDoublyLinkedList();
        list.reverseDoubly();
        list.printDoublyLinkedList();
        list.deleteAtBegin();
        list.printDoublyLinkedList();
        list.deleteAtLast();
        list.printDoublyLinkedList();
    }
}
