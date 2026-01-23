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

    int search(int x){
        int pos=1;
        NodeNew currNode=head;
        while (currNode!=null){
            if (currNode.data==x){
                return pos;
            }else{
                pos++;
                currNode=currNode.next;
            }
        }
        return -1;
    }

    int searchRecursive(int x,NodeNew head) {
        if (head == null) {
            return -1;
        }
        if (head.data == x) {
            return 1;
        } else {
            int res = searchRecursive(x,head.next);
            if (res == -1) {
                return -1;
            } else {
                return res + 1;
            }
        }
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
        System.out.print("Finding the position of element... ");
        int pos=list.search(10);
        System.out.println(pos);
        System.out.print("Finding the position of element... ");
        pos=list.searchRecursive(10,list.head);
        System.out.println(pos);
        list.printList();
    }
}
