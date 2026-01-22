package com.samit.linkedlist;

class NodeNew {
    int data;
    NodeNew next;

    NodeNew(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    NodeNew head;

    public void insertAtBegin(int data) {
        NodeNew newNode = new NodeNew(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        NodeNew newNode = new NodeNew(data);
        if (head == null) {
            head = newNode;
            return;
        }
        NodeNew temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printList() {
        NodeNew temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtBegin(2);
        list.insertAtBegin(3);
        list.insertAtBegin(4);
        list.insertAtBegin(5);
        System.out.print("Linked List after insert at begin: ");
        list.printList();
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);
        System.out.print("Linked List after insert at end: ");
        list.printList();
    }
}
