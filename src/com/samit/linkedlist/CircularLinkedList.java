package com.samit.linkedlist;

class CircularNode {
    int data;
    CircularNode next;
    CircularNode(int data) {
        this.data = data;
    }
}

public class CircularLinkedList {
    CircularNode head;
    //O(n) time complexity
    void insertAtBegin(int data){
        CircularNode newNode=new CircularNode(data);
        CircularNode temp=head;
        if (head==null){
            head=newNode;
            newNode.next=head;
            return;
        }
        while (temp.next!=head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
        head=newNode;
    }
    // O(1) time complexity
    void insertAtBeginEfficient(int data){
        CircularNode newNode=new CircularNode(data);
        if (head==null){
            head=newNode;
            newNode.next=head;
            return;
        }
        newNode.next=head.next;
        head.next=newNode;
        int temp= newNode.data;
        newNode.data= head.data;
        head.data=temp;
    }

    void insertAtEnd(int data){
        CircularNode newNode=new CircularNode(data);
        CircularNode temp=head;
        if (head==null){
            head=newNode;
            newNode.next=head;
            return;
        }
        while (temp.next!=head){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    void insertAtEndEfficient(int data){
        CircularNode newNode=new CircularNode(data);
        CircularNode temp=head;
        if (head==null){
            head=newNode;
            newNode.next=head;
            return;
        }
        newNode.next=head.next;
        head.next=newNode;
        int temp=head.data;

    }

    void printCircularList(){
        CircularNode temp=head;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    void printCircularList2() {
        CircularNode temp = head;
        System.out.print(temp.data + " ");
        for (temp = head.next; temp != head; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list=new CircularLinkedList();
        list.insertAtBegin(1);
        list.insertAtBegin(2);
        list.printCircularList2();
        list.insertAtBeginEfficient(3);
        list.printCircularList2();
        list.insertAtEnd(4);
        list.printCircularList2();
    }
}
