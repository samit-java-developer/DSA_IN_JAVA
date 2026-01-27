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
        System.out.println();
    }

    public void printMidOfList(){
        NodeNew slow = head;
        NodeNew fast = head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data+" ");
    }

    void printNthNodeFromEnd(int n){
        NodeNew first = head;
        NodeNew second = head;
        for (int i=0;i<n;i++){
            if (first==null) return;
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        System.out.println(second.data+" ");
    }

    void reverserList(){
        NodeNew next=null;
        NodeNew curr=head;
        NodeNew prev=null;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    NodeNew reverserListRecursive(NodeNew prev,NodeNew curr){
        if (curr==null){
            return prev;
        }
        NodeNew res=reverserListRecursive(curr,curr.next);
        curr.next=prev;
        return res;
    }

    NodeNew recRevL(NodeNew head){
        if(head==null||head.next==null)return head;
        NodeNew rest_head=recRevL(head.next);
        NodeNew rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }

    void removeDuplicateFromTheSortedList(){
        NodeNew curr=head;
        NodeNew next=curr.next;
        while (curr!=null && next!=null){
            if (curr.data==next.data){
                curr.next=next.next;
                next=curr.next;
            }else{
                curr=curr.next;
                next=next.next;
            }
        }
    }
    void clear(){
        head=null;
    }
    // not working code......
    void segregateEvenAndOdd(){
        NodeNew curr=head;
        NodeNew last=null;
        while (curr.next!=null){
            curr=curr.next;
        }
        last=curr;
        curr=head;
        NodeNew prev=null;
        NodeNew temp=null;
        while (curr!=null){
            if ((curr.data%2)!=0){
                last.next=curr;
                last=curr;
                if (prev!=null){
                    temp=curr.next;
                    prev.next=curr.next;
                    curr=temp;
                }else{
                    head=head.next;
                    curr=head;
                }
            }else{
                prev=curr;
                curr=curr.next;
            }
        }
    }

    static void segregateEvenAndOddEfficient(){

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
        list.printMidOfList();
        list.printNthNodeFromEnd(3);
        list.reverserList();
        list.printList();
        list.head=list.reverserListRecursive(null,list.head);
        list.printList();
        list.head=list.recRevL(list.head);
        list.printList();
        //list.clear();
        list.printList();
        list.insertAtEnd(20);
//        list.insertAtEnd(20);
//        list.insertAtEnd(20);
//        list.insertAtEnd(30);
//        list.insertAtEnd(30);
//        list.insertAtEnd(30);
        list.printList();
        list.removeDuplicateFromTheSortedList();
        list.printList();
        list.segregateEvenAndOdd();
        list.printList();
    }
}
